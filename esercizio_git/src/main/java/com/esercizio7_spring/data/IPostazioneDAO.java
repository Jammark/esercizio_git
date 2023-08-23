package com.esercizio7_spring.data;

import java.util.List;
import java.util.UUID;

import com.esercizio7_spring.model.Edificio;
import com.esercizio7_spring.model.Postazione;
import com.esercizio7_spring.model.TipoPostazione;

public interface IPostazioneDAO {

	public Postazione findById(Long id);

	public boolean isPresente(Postazione p);

	public void save(Postazione p);

	public List<Postazione> findByEdificio(Edificio e);

	public List<Postazione> findByCittà(String città, TipoPostazione tipo);

	public Postazione findByCodice(UUID codice);

}
