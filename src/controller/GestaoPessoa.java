package controller;

import model.Pessoa;

public class GestaoPessoa {

	public Pessoa addP(String nome){
		
		Pessoa p = new Pessoa(nome);
		
		return p;
	}
}
