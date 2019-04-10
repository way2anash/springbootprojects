package com.mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MultiLoginConfig {
	
	@Configuration
	@Order(1)
	public static class DearHelpUserSecConfig extends WebSecurityConfigurerAdapter{
		
		  @Override
		    @Bean
		    protected UserDetailsService userDetailsService() {
		        return new CustomUserDetailsService();
		    }
		  
		  @Bean
		    public static NoOpPasswordEncoder passwordEncoder() {
		     return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
		    }
		  
		  @Override
		    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		      auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
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
		            .csrf().disable();
		               // .userDetailsService(userDetailsService());
		    }
		
	}
	
	@Configuration
	@Order(2)
	public static class DearHelpSPSecConfig extends WebSecurityConfigurerAdapter{
		
		 @Override
		    @Bean
		    protected UserDetailsService userDetailsService() {
		        return new SPUserDetailsService();
		    }

		    @Bean
		    public static NoOpPasswordEncoder passwordEncoder() {
		     return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
		    }
		    
		    @Override
		    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		      auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		    }
		    
		    @Override
		    protected void configure(HttpSecurity http) throws Exception {
		    	http
		        .authorizeRequests()
		            .antMatchers( "/home").permitAll()
		            .antMatchers("/hellosp").access("hasRole('SP')")
		          // .antMatchers("/hellouser").access("hasRole('ADMIN')")
		          //  .anyRequest().authenticated()
		            .and()
		        .formLogin()
		     //   . loginProcessingUrl ( "/userlogin")
		            .loginPage("/login2")
		            .permitAll()
		            .and()
		        .logout()
		          //  .permitAll()
		        .logoutUrl("/logout"). 
				logoutSuccessUrl("/home")
		            .and()
		            .csrf().disable();    
		            //.userDetailsService(userDetailsService());
		    }
		
		
	}	

   }






