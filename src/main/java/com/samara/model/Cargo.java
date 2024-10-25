package com.samara.model;

import java.io.Serializable;

public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public Cargo() {
	}

	public Cargo(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + "]";
	}
}
