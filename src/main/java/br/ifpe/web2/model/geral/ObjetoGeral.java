package br.ifpe.web2.model.geral;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

import br.ifpe.web2.acesso.Usuario;

@MappedSuperclass
public abstract class ObjetoGeral {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Type(type="yes_no")
	private boolean ativo;
	@ManyToOne
	@JoinColumn(name="usuario_criador")
	private Usuario criadoPor;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;	
	@ManyToOne
	@JoinColumn(name="usuario_alterador")
	private Usuario alteradorPor;
//	@Version
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Usuario getCriadoPor() {
		return criadoPor;
	}
	public void setCriadoPor(Usuario criadoPor) {
		this.criadoPor = criadoPor;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Usuario getAlteradorPor() {
		return alteradorPor;
	}
	public void setAlteradorPor(Usuario alteradorPor) {
		this.alteradorPor = alteradorPor;
	}
	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}
	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
	
}
