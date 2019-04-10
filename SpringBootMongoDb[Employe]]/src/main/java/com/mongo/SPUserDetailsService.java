package com.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class SPUserDetailsService implements UserDetailsService {

	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        ServiceProviders user =
                mongoTemplate.findOne(query, ServiceProviders.class);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("email %s not found", email));
        }

        

        return new User(user.getEmail(), user.getPassword(),
             AuthorityUtils.createAuthorityList(user.getRole()));
        		//AuthorityUtils.createAuthorityList(user.getRole()));
    }
}
                 


