package com.esercizio7_spring.data;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio7_spring.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	Optional<Prenotazione> findByDataAndPostazioneId(LocalDate data, Long id);

	Optional<Prenotazione> findByUserIdAndData(Long id, LocalDate data);

}
