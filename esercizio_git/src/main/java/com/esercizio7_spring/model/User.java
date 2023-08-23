package com.esercizio7_spring.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "utenti")
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;
	@Column(name = "nome_completo")
	private String nomeCompleto;
	private String email;

	@OneToMany(mappedBy = "user")
	private Set<Prenotazione> prenotazioni;


	private String password;

	public User(String username, String nomeCompleto, String email) {
		super();
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
	}

}
