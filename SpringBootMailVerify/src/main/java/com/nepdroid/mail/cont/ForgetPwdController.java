package com.nepdroid.mail.cont;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nepdroid.mail.model.UserMailDemo;
import com.nepdroid.mail.serv.EmailService;
import com.nepdroid.mail.serv.UserService;

@Controller
public class ForgetPwdController {
  private String resetToken;
	@Autowired 
	private EmailService emailService;
	@Autowired 
	private UserService userService;
	
	@GetMapping("/forgetPassword")
	public String forgetPassword() {
		return "forgetPwdForm";
		
	}
	@PostMapping("/forgetPassword")
	public String emailForgetPwd(HttpServletRequest request,@RequestParam("email") String email,Model model) {
		UserMailDemo user = userService.findByEmail(email);
		user.setResetToken(UUID.randomUUID().toString());
		
		userService.saveUser(user);
		String appUrl = request.getScheme() + "://" + request.getServerName()+":" +request.getServerPort();
		
		SimpleMailMessage resetEmail = new SimpleMailMessage();
		resetEmail.setTo(user.getEmail());
		resetEmail.setSubject("Password Reset");
		resetEmail.setText("To reset your password , please click the link below:\n"
				+ appUrl + "/resetPwd?token=" + user.getResetToken());
		resetEmail.setFrom("noreply@domain.com");
		
		emailService.sendEmail(resetEmail);
		model.addAttribute("message","A password reset link has been sent to "+user.getEmail());
		return"resetToken";
	}
	
	@GetMapping("/resetPwd")
	public String resetPwdToken(Model model,@RequestParam("token") String token) {
		
		UserMailDemo user = userService.findByResetToken(token);
		if(user!=null)
		{
			resetToken=token;
		}
		else {
			model.addAttribute("errorMessage", "Oops!  This is an invalid password reset link.");
			return"forgetPwdForm";
		}
		return"resetPwdForm";
		
	}
	
	@PostMapping("/resetPwd")
	public String resetPassword(@RequestParam("password") String password) {
		
		UserMailDemo user = userService.findByResetToken(resetToken);
		user.setPassword(password);
		user.setResetToken(null);
		userService.saveUser(user);
		
		return"pwdResetSuccess";
	}
	
}



















