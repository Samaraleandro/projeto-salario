package com.samara.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.samara.model.PessoaSalarioConsolidado;
import com.samara.model.dao.PessoaSalarioConsolidadoDAO;

import com.samara.service.SalarioCalculoService;

@ManagedBean(name="salarioConsolidadoBean")
@ViewScoped
public class SalarioConsolidadoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<PessoaSalarioConsolidado> listaPessoasSalarios = new ArrayList<>();;

    public SalarioConsolidadoBean() {
        carregarSalarios(); 
    }

    public void calcularSalarios() {
        SalarioCalculoService salarioCalculoService = new SalarioCalculoService();
        salarioCalculoService.calcularSalarios();
        carregarSalarios();
    }

    public void carregarSalarios() {
        PessoaSalarioConsolidadoDAO dao = new PessoaSalarioConsolidadoDAO();
        listaPessoasSalarios = dao.buscarPessoasSalarios();
    }
    
    public List<PessoaSalarioConsolidado> getListaPessoasSalarios() {
        return listaPessoasSalarios;
    }
}
