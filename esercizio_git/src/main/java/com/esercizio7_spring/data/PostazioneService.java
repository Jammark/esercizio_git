package com.esercizio7_spring.data;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esercizio7_spring.model.Edificio;
import com.esercizio7_spring.model.Postazione;
import com.esercizio7_spring.model.TipoPostazione;

@Service
public class PostazioneService implements IPostazioneDAO {

	@Autowired
	private PostazioneRepository repo;

	@Override
	public Postazione findById(Long id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public boolean isPresente(Postazione p) {

		return repo.findByCodice(p.getCodice()).isPresent();
	}

	@Override
	public void save(Postazione p) {
		repo.save(p);

	}

	@Override
	public List<Postazione> findByEdificio(Edificio e) {
		if (e.getId() != null) {
			return repo.findByEdificioId(e.getId());
		} else {
			throw new IllegalArgumentException("Edificio passato non ha id:" + e);
		}
	}

	@Override
	public List<Postazione> findByCittà(String città, TipoPostazione tipo) {

		return repo.findByTipoAndEdificioCittà(tipo, città);
	}

	@Override
	public Postazione findByCodice(UUID codice) {

		return repo.findByCodice(codice).orElse(null);
	}

}
