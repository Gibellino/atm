package model;

public class ContaBancaria {

	private float saldo;
	private int numero;
	private Pessoa t;
	
	public ContaBancaria(int numero, Pessoa p) {
		this.saldo = 0;
		this.numero = numero;
		this.t = p;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pessoa getP() {
		return t;
	}

	public void setP(Pessoa p) {
		this.t = p;
	}
	
	public String toString(boolean t){
		if(t == true){
			return "Conta " + getNumero()
			+ ":\n Nome titular: " + getP().getNome()
			+ "\n Saldo: " + getSaldo();
		}else{
			return "Conta " + getNumero() + " - " + getP().getNome();
		}
	}
	
}
