package com.demo.springapp.config.dao;

import java.util.List;

import com.demo.springapp.entities.User;

public interface UserDao {
	
	public List<User> findAll();
	
	public User create(User user);
	
	public User findUserById(int id);

	public User login(String email, String password);
}
