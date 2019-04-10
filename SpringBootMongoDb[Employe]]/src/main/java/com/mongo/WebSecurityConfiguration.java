/*
package com.mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity

@Order(1)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
            .antMatchers( "/home").permitAll()
            .antMatchers("/hellouser").access("hasRole('USER')")
          //  .antMatchers("/hello").access("hasRole('ADMIN')")
          //  .anyRequest().authenticated()
            .and()
        .formLogin()
     //   . loginProcessingUrl ( "/userlogin")
            .loginPage("/login1")
            .permitAll()
            .and()
        .logout()
          //  .permitAll()
        .logoutUrl("/logout"). 
		logoutSuccessUrl("/home")
            .and()
                .userDetailsService(userDetailsService());
    }

}                   */                      
