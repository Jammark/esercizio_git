package com.progettosettimana17.progsett17;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esercizio7_spring.data.IPostazioneDAO;
import com.esercizio7_spring.model.Postazione;
import com.esercizio7_spring.model.TipoPostazione;

import lombok.extern.slf4j.Slf4j;
//prova3
@SpringBootTest
@Slf4j
class Progsett17ApplicationTests {

	@Autowired
	private IPostazioneDAO poDao;

	@Test
	void contextLoads() {

		List<Postazione> l = poDao.findByCittà("Lake Darron", TipoPostazione.SALA_RIUNIONI);
		l.forEach(p -> log.info("Found: " + p));
		assertFalse(l.isEmpty());

	}

}
