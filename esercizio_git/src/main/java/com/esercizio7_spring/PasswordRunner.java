package com.esercizio7_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.esercizio7_spring.data.IUserDAO;

import lombok.extern.slf4j.Slf4j;

@Order(1)
@Component
@Slf4j
public class PasswordRunner implements CommandLineRunner {

	@Autowired
	private IUserDAO dao;

	@Override
	public void run(String... args) throws Exception {
		dao.findAll().forEach(u -> log.info("user: " + u.getUsername() + " PASSWORD: " + u.getPassword()));

	}

}
