package br.ifpe.web2.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.ifpe.web2.model.geral.ObjetoGeral;

@Entity
public class Cargo extends ObjetoGeral{
	
	@Column(length = 25, nullable = false)
	private String nome;
	private double salario;
	
	public Cargo() {
	}

	public Cargo(String _nome) {
		setNome(_nome);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

}
