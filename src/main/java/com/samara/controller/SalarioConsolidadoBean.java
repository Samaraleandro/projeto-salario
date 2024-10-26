package com.samara.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.samara.model.PessoaSalarioConsolidado;
import com.samara.model.dao.PessoaSalarioConsolidadoDAO;

import com.samara.service.SalarioCalculoService;
import com.samara.util.Conexao;

@ManagedBean(name = "salarioConsolidadoBean")
@ViewScoped
public class SalarioConsolidadoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<PessoaSalarioConsolidado> listaPessoasSalarios = new ArrayList<>();
	private boolean mostrarTabela = false;

	public SalarioConsolidadoBean() {
		carregarSalarios();
	}

	public void calcularSalarios() {
		SalarioCalculoService salarioCalculoService = new SalarioCalculoService();
		salarioCalculoService.calcularSalarios();
		carregarSalarios();
		mostrarTabela = true;
	}

	public void carregarSalarios() {
		try (Connection connection = Conexao.getConnection()) {
			PessoaSalarioConsolidadoDAO dao = new PessoaSalarioConsolidadoDAO(connection);
			listaPessoasSalarios = dao.buscarPessoasSalarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<PessoaSalarioConsolidado> getListaPessoasSalarios() {
		return listaPessoasSalarios;
	}
	
    public boolean getMostrarTabela() {
        return mostrarTabela;
    }
}
