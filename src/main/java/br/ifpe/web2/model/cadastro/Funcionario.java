package br.ifpe.web2.model.cadastro;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import br.ifpe.web2.model.geral.ObjetoGeral;

@Entity
public class Funcionario extends ObjetoGeral{
	
	@Column(length = 8, nullable = false)
	@Length(max = 8, message = "Matrícula deve ter até 8 dígitos")
	@Pattern(regexp = "[0-9]+", message = "Matrícula deve ter apenas dígitos")
	@NotBlank(message = "Matrícula deve ser informada")
	private String matricula;
	
	@Column(length = 70, nullable = false)
	@Length(max = 70, message = "Nome deve ter até 70 dígitos")
	@NotBlank(message = "Nome deve ser informado")
	private String nome;
	
	@Column(length = 14, nullable = false)
	@CPF(message = "CPF não é valido")
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;

	@ManyToOne
	@JoinColumn(name = "cargo_codigo")
	@NotNull(message = "Cargo deve ser informado")
	private Cargo cargo;
	
	@ManyToOne
	@NotNull(message = "Empresa deve ser informada")
	private Empresa empresa;
	
	@ManyToOne
	private Funcionario chefe;
	
	@ManyToMany
	private List<Funcionario> assessores;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Funcionario getChefe() {
		return chefe;
	}
	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}
	
	
	
	
}
