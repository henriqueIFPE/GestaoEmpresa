                                              package br.ifpe.web2.acesso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.ifpe.web2.model.geral.ObjetoGeral;

@Entity
public class Usuario extends ObjetoGeral{

	@Column(length = 70, nullable = false)
	private String nome;
	@Column(length = 40, nullable = false, unique = true)
	private String login;
	@Column(length = 40, nullable = false)
	private String senha;
	@Enumerated(EnumType.STRING)
	@Column(length = 15, nullable = false)
	private Perfil perfil;
	@Enumerated(EnumType.STRING)
	@Column(length = 15, nullable = false)
	private SituacaoUsuario situacaoUsuario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public SituacaoUsuario getSituacaoUsuario() {
		return situacaoUsuario;
	}
	public void setSituacaoUsuario(SituacaoUsuario situacaoUsuario) {
		this.situacaoUsuario = situacaoUsuario;
	}
	
	
}
