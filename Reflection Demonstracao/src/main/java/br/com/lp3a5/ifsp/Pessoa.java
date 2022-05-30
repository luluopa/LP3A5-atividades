package main.java.br.com.lp3a5.ifsp;

import java.util.*;

public class Pessoa {
	private String nome;
	private int idade;
	private String cpf;
	private String rg;
         
	public Pessoa(String nome, int idade, String cpf, String rg) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public String getCpf() {
		return cpf;
	}
	public String getRg() {
		return rg;
	}
}



