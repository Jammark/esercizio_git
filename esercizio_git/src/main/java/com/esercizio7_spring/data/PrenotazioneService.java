package com.esercizio7_spring.data;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esercizio7_spring.model.Postazione;
import com.esercizio7_spring.model.Prenotazione;
import com.esercizio7_spring.model.User;

@Service
public class PrenotazioneService implements IPrenotazioneDAO {

	@Autowired
	private PrenotazioneRepository repo;

	@Override
	public void save(Prenotazione p) {
		repo.save(p);

	}

	@Override
	public boolean isPresente(Prenotazione p) {

		return false;
	}

	@Override
	public Prenotazione findById(Long id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public boolean isOccupata(Postazione p, LocalDate data) {
		if (p.getId() == null) {
			throw new IllegalArgumentException("Postazione passata senza un id:" + p);
		}
		return repo.findByDataAndPostazioneId(data, p.getId()).isPresent();
	}

	@Override
	public boolean isPuòPrenotare(User u, LocalDate data) {
		if (u.getId() == null) {
			throw new IllegalArgumentException("Utente passato privo di id.");
		}
		return repo.findByUserIdAndData(u.getId(), data).isEmpty();
	}

}
