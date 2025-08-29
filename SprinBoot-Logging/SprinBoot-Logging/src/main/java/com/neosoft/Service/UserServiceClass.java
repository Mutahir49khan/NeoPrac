package com.neosoft.Service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.User;
import com.neosoft.repository.UserRepoInterface;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceClass {
	
	@Autowired
	private UserRepoInterface repo;
	//Apply logger
	 private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceClass.class);
	 
	//Create-User
	public User createUser(User user) {
		logger.info("New Usre Created With POstAMn By Passing Json Content ");
	   return 	repo.save(user);
	}
	
	//getAllUser
	public List<User> getAllUser(){
		logger.info("before Find All() MEthod ExecutionnStrats ");
		return repo.findAll();
		//logger.info("After Find All() MEthod ExecutionnStrats ");
				
	}
	
	
	//getTheUSerById
	
	public User userById(Long id ) {
		logger.info("before findById () method is Executed ");
		return repo.findById( id).
				//copilot code
			//	orElseThrow(() -> {
		     //       logger.error("User with ID {} not found for update", id);
		           // return new RuntimeException("User not found");
		     //   });
		orElseThrow(()->{
				logger.error("this is not a valid kindly check and try again");
			return	new RuntimeException("User is not Found with this id you have given");});
	}
	
	
	
	
	
	
	
	
	

}
