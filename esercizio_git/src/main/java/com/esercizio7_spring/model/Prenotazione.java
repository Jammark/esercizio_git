package com.esercizio7_spring.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prenotazioni", uniqueConstraints = {
		@jakarta.persistence.UniqueConstraint(columnNames = { "data", "postazione_id" }) })
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "postazione_id")
	private Postazione postazione;

	public Prenotazione(LocalDate data, User user, Postazione postazione) {
		super();
		this.data = data;
		this.user = user;
		this.postazione = postazione;
	}

}
