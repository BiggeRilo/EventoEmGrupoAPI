package br.com.atomjuice.EventoEmGrupo.model.entities;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotNull
	@JsonFormat(pattern = "yyy-MM-dd", shape = Shape.STRING)
	private Date inicio;


	@NotNull
	@JsonFormat(pattern = "yyy-MM-dd", shape = Shape.STRING)
	private Date termino;

	
	private long duracao;
	
	@NotBlank
	private	String nome;
	@NotBlank
	private	String descricao;
	@NotBlank
	private	String local;

	
	private	boolean publicado;
	
	private	boolean excluido;
	
	public Evento(){
		//Construtor padrao
	}
	
	public Evento(Date inicio, Date termino, long duracao,  String nome, String descricao, String local,boolean publicado) {
		super();
		this.inicio = inicio;
		this.termino = termino;
		this.duracao = duracao;
		this.nome = nome;
		this.descricao = descricao;
		this.local = local;
		this.publicado = publicado;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public long getDuracao() {
		return duracao;
	}

	public void setDuracao(Date inicio, Date termino){
		this.duracao = (termino.getTime() - inicio.getTime()) / (1000*60*60*24);
	}
	
	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

}
