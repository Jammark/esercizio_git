package com.esercizio7_spring.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio7_spring.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

	Optional<Edificio> findByNome(String nome);

}
