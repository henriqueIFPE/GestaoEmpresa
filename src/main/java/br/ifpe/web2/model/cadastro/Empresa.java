package br.ifpe.web2.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.ifpe.web2.model.geral.ObjetoGeral;

@Entity
public class Empresa extends ObjetoGeral {

	@Column(length = 100, nullable = false)
	private String nomeRazaoSocial;
	@Column(length = 70)
	private String nomeResponsavel;
	@Column(length = 25)
	private String telefone;
	
	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}
	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
