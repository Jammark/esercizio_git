package com.esercizio7_spring.data;

import java.time.LocalDate;

import com.esercizio7_spring.model.Postazione;
import com.esercizio7_spring.model.Prenotazione;
import com.esercizio7_spring.model.User;

public interface IPrenotazioneDAO {

	public void save(Prenotazione p);

	public boolean isPresente(Prenotazione p);

	public Prenotazione findById(Long id);

	public boolean isOccupata(Postazione p, LocalDate data);

	public boolean isPuòPrenotare(User u, LocalDate data);

}
