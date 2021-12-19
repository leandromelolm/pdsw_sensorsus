package br.com.sensorsus.sensorsus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AvaliacaoEstabelecimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAvaliacao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataCriacao;
	
	private String descricao;
	private Double classificacao;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="estabelecimento_id")
	private Estabelecimento estabelecimento;	
	
	public AvaliacaoEstabelecimento() {	
		
	}

	public AvaliacaoEstabelecimento(Integer idAvaliacao, Date dataCriacao, String descricao, Double classificacao,
			Usuario usuario, Estabelecimento estabelecimento) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.dataCriacao = dataCriacao;
		this.descricao = descricao;
		this.classificacao = classificacao;
		this.usuario = usuario;
		this.estabelecimento = estabelecimento;
	}

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Double classificacao) {
		this.classificacao = classificacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAvaliacao == null) ? 0 : idAvaliacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoEstabelecimento other = (AvaliacaoEstabelecimento) obj;
		if (idAvaliacao == null) {
			if (other.idAvaliacao != null)
				return false;
		} else if (!idAvaliacao.equals(other.idAvaliacao))
			return false;
		return true;
	}	

}
