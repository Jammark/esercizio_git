package com.esercizio7_spring.data;

import java.util.List;

import com.esercizio7_spring.model.User;

public interface IUserDAO {

	public User findById(Long id);

	public void save(User u);

	public boolean isPresent(User u);

	public User findByUsername(String username);

	public List<User> findAll();

}
