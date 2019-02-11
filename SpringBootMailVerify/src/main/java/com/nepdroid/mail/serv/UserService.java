package com.nepdroid.mail.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nepdroid.mail.model.UserMailDemo;
import com.nepdroid.mail.model.repo.MailRepository;

@Service("userService")
public class UserService {

	private MailRepository mailRepository;
	
    @Autowired
    public UserService(MailRepository mailRepository) { 
      this.mailRepository = mailRepository;
    }
    
	public UserMailDemo findByEmail(String email) {
		return mailRepository.findByEmail(email);
	}
	
	public UserMailDemo findByConfirmationToken(String confirmationToken) {
		return mailRepository.findByConfirmationToken(confirmationToken);
	}
	
	public void saveUser(UserMailDemo user) {
		mailRepository.save(user);
	}



	public UserMailDemo findByResetToken(String token) {
		// TODO Auto-generated method stub
		return mailRepository.findByResetToken(token);
	}

}
