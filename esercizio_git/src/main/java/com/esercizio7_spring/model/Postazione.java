package com.esercizio7_spring.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "postazioni")
@Getter
@Setter

@NoArgsConstructor
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false)
	private UUID codice;

	private String descrizione;

	@Enumerated(jakarta.persistence.EnumType.STRING)
	private TipoPostazione tipo;

	@Column(name = "max_occupanti")
	private int maxOccupanti;

	@ManyToOne
	@JoinColumn(name = "edificio_id")
	private Edificio edificio;

	public Postazione(String descrizione, TipoPostazione tipo, int maxOccupanti) {
		super();
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.maxOccupanti = maxOccupanti;
		this.codice = UUID.randomUUID();
	}

	@Override
	public String toString() {
		return "Postazione [id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + ", tipo=" + tipo
				+ ", maxOccupanti=" + maxOccupanti + ", edificio=" + edificio.getId() + "]";
	}

}
