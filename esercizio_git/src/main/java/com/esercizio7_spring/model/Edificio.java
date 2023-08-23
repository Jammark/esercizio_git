package com.esercizio7_spring.model;

import java.util.Set;

import com.esercizio7_spring.CodiceConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
@Table(name = "edifici")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String città;
	private String indirizzo;
	@Column(nullable = false)
	private String nome;

	@Column(length = 8)
	@Convert(converter = CodiceConverter.class)
	private String codice;

	@OneToMany(mappedBy = "edificio")
	private Set<Postazione> postazioni;

	public Edificio(String città, String indirizzo, String nome) {
		super();
		this.città = città;
		this.indirizzo = indirizzo;
		this.nome = nome;
	}

}
