package com.esercizio7_spring.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio7_spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNomeCompleto(String nomeCompleto);

	Optional<User> findByUsername(String username);

	List<User> findAll();

}
