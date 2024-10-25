package com.samara.model;

import java.io.Serializable;

public class Vencimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private String descricao;
    private String tipo; 
    private Double valor;

    public Vencimento() {}

    public Vencimento(Integer id, String descricao, String tipo, Double valor, Pessoa pessoa) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

	@Override
	public String toString() {
		return "Vencimento [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", valor=" + valor + "]";
	}
}
