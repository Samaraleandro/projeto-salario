package com.samara.model;

import java.io.Serializable;

public class CargoVencimentos implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Cargo cargo;
	private Vencimento vencimento;

	public CargoVencimentos() {
	}

	public CargoVencimentos(Integer id, Cargo cargo, Vencimento vencimento) {
		this.id = id;
		this.cargo = cargo;
		this.vencimento = vencimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public void setVencimento(Vencimento vencimento) {
		this.vencimento = vencimento;
	}

	@Override
	public String toString() {
		return "CargoVencimentos [id=" + id + ", cargo=" + cargo + ", vencimento=" + vencimento + "]";
	}

}
