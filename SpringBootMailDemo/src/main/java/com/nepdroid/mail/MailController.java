package com.nepdroid.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MailController {

	  @Autowired
		private EmailService emailService;
	  
	  @PostMapping(value = "/sendEmail")
		public String processForgotPasswordForm(Model model, @RequestParam("to") String to,
				@RequestParam("from") String from,@RequestParam("subject") String subject,
				@RequestParam("text") String text) {

		
				SimpleMailMessage demoEmail = new SimpleMailMessage();
				demoEmail.setFrom(from);
				demoEmail.setTo(to);
				demoEmail.setSubject(subject);
				demoEmail.setText(text);       
				
				emailService.sendEmail(demoEmail);

				// Add success message to view
				model.addAttribute("successMessage", "Mail sent succesfully." );
	                       return "result";
			}
}
