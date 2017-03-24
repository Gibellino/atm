package controller;

import java.util.ArrayList;

import model.ContaBancaria;
import model.Pessoa;

public class GestaoConta {

	public void addC(ArrayList<ContaBancaria> cb, String nome){
		
		Pessoa p = new GestaoPessoa().addP(nome);
		
		cb.add(new ContaBancaria(cb.size()+1, p));
	}
	
	public void levantar(ArrayList<ContaBancaria> cb, int nif, float m){
		cb.get(nif).setSaldo(cb.get(nif).getSaldo()-m);
	}
	
	public void depositar(ArrayList<ContaBancaria> cb, int nif ,float m){
		cb.get(nif).setSaldo(cb.get(nif).getSaldo()+m);	
	}
	
	public void print(ArrayList<ContaBancaria> cb, boolean t){
		for(ContaBancaria c : cb){
			System.out.println(c.toString(t));
		}
	}
	
}
