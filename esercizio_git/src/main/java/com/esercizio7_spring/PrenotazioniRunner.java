package com.esercizio7_spring;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.esercizio7_spring.data.IPostazioneDAO;
import com.esercizio7_spring.data.IPrenotazioneDAO;
import com.esercizio7_spring.data.IUserDAO;
import com.esercizio7_spring.model.Edificio;
import com.esercizio7_spring.model.User;

import lombok.extern.slf4j.Slf4j;

@Order(0)
@Component
@Slf4j
public class PrenotazioniRunner implements CommandLineRunner {

	@Autowired
	private IPrenotazioneDAO prDao;

	@Autowired
	private IPostazioneDAO poDao;

	@Autowired
	private IUserDAO uDao;

	@Override
	public void run(String... args) throws Exception {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Esercizio7SrpingApplication.class);

		Edificio edificio1 = (Edificio) ctx.getBean("getEdificio1");
		Edificio edificio2 = (Edificio) ctx.getBean("getEdificio2");

		User u1 = (User) ctx.getBean("getUtente");
		User u2 = (User) ctx.getBean("getUtente");
		/*
		 * List<Postazione> lista = new ArrayList<Postazione>(); try { List<Postazione>
		 * lista1 = poDao.findByEdificio(edificio1); if (lista1.isEmpty()) { Postazione
		 * p1 = (Postazione) ctx.getBean("getPostazione"); p1.setEdificio(edificio1);
		 * poDao.save(p1); lista.add(p1); } else { lista.addAll(lista1); }
		 * 
		 * List<Postazione> lista2 = poDao.findByEdificio(edificio2); if
		 * (lista2.isEmpty()) { Postazione p2 = (Postazione)
		 * ctx.getBean("getPostazione"); p2.setEdificio(edificio2); poDao.save(p2);
		 * lista.add(p2); } else { lista.addAll(lista2); }
		 * 
		 * log.info("Ricarca postazioni per città: " + edificio1.getCittà());
		 * List<Postazione> ricerca = poDao.findByCittà(edificio1.getCittà(),
		 * TipoPostazione.OPENSPACE); ricerca.forEach(e ->
		 * log.info(TipoPostazione.OPENSPACE.name() + "" + e)); ricerca =
		 * poDao.findByCittà(edificio1.getCittà(), TipoPostazione.PRIVATO);
		 * ricerca.forEach(e -> log.info(TipoPostazione.PRIVATO.name() + "" + e));
		 * ricerca = poDao.findByCittà(edificio1.getCittà(),
		 * TipoPostazione.SALA_RIUNIONI); ricerca.forEach(e ->
		 * log.info(TipoPostazione.SALA_RIUNIONI.name() + "" + e));
		 * 
		 * User u1 = (User) ctx.getBean("getUtente"); Postazione p = lista.get(0);
		 * LocalDate data = LocalDate.now().plusDays(3); if (prDao.isOccupata(p, data))
		 * { log.info("Postazione " + p + " prenotata in data " + data); } else {
		 * Prenotazione pr = new Prenotazione(data, u1, p); prDao.save(pr); boolean
		 * check = prDao.isOccupata(p, data); log.info("Postazione " + p + (check ?
		 * " già occupata " : " non occupata ") + "in data " + data); }
		 * 
		 * Scanner sc = new Scanner(System.in); log.info("Selezionare una postazione.");
		 * lista.forEach(post -> log.info(1 + lista.indexOf(post) +
		 * " per postazione in edificio " + post.getEdificio().getNome() + " tipo " +
		 * post.getTipo())); int num = selectNumero(sc, lista.size()); Postazione post =
		 * lista.get(--num);
		 * log.info("Inserire numero di giorni a partire dalla data corrente, max 100");
		 * int numData = selectNumero(sc, 100); data =
		 * LocalDate.now().plusDays(numData);
		 * 
		 * if (prDao.isOccupata(post, data)) { log.info("Postazione " + post);
		 * log.info(" occupata in data " + data); } else { Prenotazione pr = new
		 * Prenotazione(data, u1, post); prDao.save(pr); boolean check =
		 * prDao.isOccupata(post, data); log.info("Postazione " + p); log.info("" +
		 * (check ? " prenotata " : " non prenotata ") + "per data " + data); }
		 * 
		 * log.info("Selezionare un utente"); List<User> lu = uDao.findAll();
		 * lu.forEach(u -> log.info(1 + lu.indexOf(u) + " per " + u.getNomeCompleto()));
		 * int numU = selectNumero(sc, lu.size()); User user = lu.get(--numU);
		 * log.info("Inserire numero di giorni a partire dalla data corrente, max 100");
		 * numData = selectNumero(sc, 100); data = LocalDate.now().plusDays(numData);
		 * boolean free = prDao.isPuòPrenotare(user, data); if (free) {
		 * log.info("L'utente " + user.getNomeCompleto() +
		 * " è libero di prenotare in data " + data); } else { log.info("L'utente " +
		 * user.getNomeCompleto() + " non può prenotare in data " + data); }
		 * 
		 * } catch (IllegalArgumentException e) { log.error(e.getMessage()); } catch
		 * (NoSuchElementException e) { log.error(e.getMessage()); }
		 * 
		 */

		ctx.close();

	}

	protected int selectNumero(Scanner sc, int max) {
		if (sc.hasNextInt()) {
			int val = sc.nextInt();
			if (val < 1 || val > max) {
				System.out.println("Valore inserito non corretto! Riprovare.");
				return selectNumero(sc, max);
			}
			sc.nextLine();
			return val;
		} else {
			sc.next();
			System.out.println("Inserire un valore numerico.");
			return selectNumero(sc, max);
		}
	}

	protected boolean conferma(Scanner sc) {
		String input = sc.nextLine().toLowerCase();
		if (input.equals("y")) {
			return false;
		} else if (input.equals("n")) {
			return true;
		} else {
			System.out.println("Valore inserito non valido.");
			return conferma(sc);
		}
	}

}
