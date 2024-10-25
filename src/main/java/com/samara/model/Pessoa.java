package com.samara.model;

import java.io.Serializable;

public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cidade;
	private String email;
	private String cep;
	private String endereco;
	private String pais;
	private String usuario;
	private String telefone;
	private String dataNascimento;
	private Cargo cargo;

	public Pessoa() {
	}

	public Pessoa(Integer id, String nome, String cidade, String email, String cep, String endereco, String pais,
			String usuario, String telefone, String dataNascimento, Cargo cargo) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.pais = pais;
		this.usuario = usuario;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.cargo = cargo;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", email=" + email + ", cep=" + cep
				+ ", endereco=" + endereco + ", pais=" + pais + ", usuario=" + usuario + ", telefone=" + telefone
				+ ", dataNascimento=" + dataNascimento + ", cargo=" + cargo + "]";
	}
}
