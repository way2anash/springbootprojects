package com.nepdroid.mail.model.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nepdroid.mail.model.UserMailDemo;

@Repository
public interface MailRepository extends MongoRepository<UserMailDemo,String> {

	
	UserMailDemo findByEmail(String email);
	UserMailDemo findByConfirmationToken(String confirmationToken);
	UserMailDemo findByResetToken(String token);

	
}
