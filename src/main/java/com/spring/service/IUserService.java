package com.spring.service;
import java.util.List;
import com.spring.entity.User;
public interface IUserService {
	List<User> retrieveAllUsers();
	User addUser(User user);
	User updateUser(User user);
	void deleteUser(Long id);
	User retrieveUser(Long id);

}
