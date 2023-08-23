package com.esercizio7_spring.data;

import com.esercizio7_spring.model.Edificio;

public interface IEdificioDAO {

	public Edificio findById(Long id);

	public boolean isPresente(Edificio e);

	public void save(Edificio e);

	public Edificio findByNome(String nome);
}
