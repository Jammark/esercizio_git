package com.esercizio7_spring.data;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio7_spring.model.Postazione;
import com.esercizio7_spring.model.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	List<Postazione> findByEdificioId(Long id);

	List<Postazione> findByTipoAndEdificioCittà(TipoPostazione tipo, String città);

	Optional<Postazione> findByCodice(UUID codice);
}
