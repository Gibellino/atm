package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GestaoConta;
import model.ContaBancaria;
import model.Pessoa;

public class Main {

	static Scanner read = new Scanner(System.in);
	
	static ArrayList<ContaBancaria> cb = new ArrayList<ContaBancaria>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int op=0;
		
		do{
			
			System.out.println("\tMenu:");
			System.out.println(" 1- Inserir;\n"
					+ " 2- Listar;\n"
					+ " 3- Entrar;\n"
					+ " 0- Sair;\n");
			System.out.printf("Insira a opção desejada: ");
			
			try{
				op = read.nextInt();
			}
			catch(Exception e){
				op = 10;
				read.next();
			}
			
			System.out.println();
			
			switch(op){
			
			case 1: add(); break;
			case 2: new GestaoConta().print(cb, true); break;
			case 3: entrar(); break;
			case 0: System.out.println("\nVai Sair!"); break;
			
			default: System.out.println("\nOpção Inválida!");
			
			}
			
			System.out.println();
			
		}while(op != 0);	
	}

	public static void add(){
		
				read.nextLine();
		
				System.out.printf("\nInsira o nome do cliente: ");
				String nome = read.nextLine();
				
				new GestaoConta().addC(cb, nome);
	}
	
	public static void entrar(){
		
		if(cb.size() > 0){
			int nif=0;
			
			do{
				System.out.printf("Login:"
						+ "\n Numero: ");
				nif = read.nextInt();
				
				System.out.println("NIf ==" + nif + "\n CB Size = " + cb.size() + "\n");
				
				for(int i=0; i< cb.size(); i++){
					if(nif == cb.get(i).getNumero()){
						nif = i;
						break;
					}
					else{
						nif = cb.size()+1;
					}
				}
				
				System.out.println("NIf ==" + nif + "\n CB Size = " + cb.size() + "\n");
				
			}while(nif > cb.size());
			
			
			System.out.println("\nBem-Vindo, " + cb.get(nif).getP().getNome() + "!");
			
			menuL(nif);
		}
		else{
			System.out.println("\nInsira contas primeiro!");
		}
	}
	
	public static void menuL(int nif){
		
		int op=0;
		
		do{
			
			System.out.println("\tMenu:");
			System.out.println(" 1- Levantar;\n"
					+ " 2- Depositar;\n"
					+ " 3- Transferir;\n"
					+ " 0- Sair;\n");
			System.out.printf("Insira a opção desejada: ");
			
			try{
				op = read.nextInt();
			}
			catch(Exception e){
				op = 10;
				read.next();
			}
			
			System.out.println();
			
			float m=0;
			
			switch(op){
			
			case 1:
				
				do{
				System.out.printf("Digita o montante que deseja levantar: ");
				m= read.nextFloat();
				
				if(cb.get(nif).getSaldo() >= m){
					break;
				}
				else{
					System.out.println("\nSaldo insuficiente!");
					continue;
				}
				
				}while(true);
				
				new GestaoConta().levantar(cb, nif, m);
				
				break;
				
			case 2:
				
				System.out.printf("Insira o montante que deseja depositar: ");
				m = read.nextFloat();
				
				new GestaoConta().depositar(cb, nif, m);
				
				break;
				
			case 3: 
				
				System.out.println("");
				new GestaoConta().print(cb, false);
				System.out.printf("\nInsira o numero da conta que deseja transferir: ");
				int id = read.nextInt()-1;
				
				do{
					System.out.printf("Digita o montante que deseja transferir: ");
					m= read.nextFloat();
					
					if(cb.get(nif).getSaldo() >= m){
						break;
					}
					else{
						System.out.println("\nSaldo insuficiente!");
						continue;
					}
					
					}while(true);
				
				new GestaoConta().levantar(cb, nif, m);
				new GestaoConta().depositar(cb, id, m);
				
				break;
			
			}
			
		}while(op != 0);
		
	}
	
}
