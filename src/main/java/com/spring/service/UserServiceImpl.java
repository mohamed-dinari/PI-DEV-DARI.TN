package com.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired 
	UserRepository userRepository;
	private static final Logger L =LogManager.getLogger(UserServiceImpl.class);

	
	/**@Override
	public User addUser(User u){}
	@Override
	public void deleteUser(String id){}
	@Override
	public User updateUser(User u){}
	@Override
	public User retrieveUser(String id){}*/
	@Override
	public User addUser(User user){
		return userRepository.save(user);
	}
		@Override
		public User updateUser(User user){
			return userRepository.save(user);
		}
		@Override
		public User retrieveUser(Long id){
			return userRepository.findById(id).get();
		}
	@Override
	public List<User> retrieveAllUsers() {
			List<User> users =(List<User>) userRepository.findAll();
			
			for (User user : users) {
				L.info("user +++: "+ user);
				
			}
		return users;
	
	}
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}
	


}



