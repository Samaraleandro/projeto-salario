package com.samara.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samara.model.Cargo;
import com.samara.model.Pessoa;
import com.samara.model.PessoaSalarioConsolidado;
import com.samara.util.Conexao;

public class PessoaSalarioConsolidadoDAO {

    public List<PessoaSalarioConsolidado> buscarPessoasSalarios() {
        List<PessoaSalarioConsolidado> listaPessoaSalarioConsolidado = new ArrayList<>();
        String query = "SELECT pessoa_id, nome_pessoa, nome_cargo, salario FROM pessoa_salario_consolidado order by pessoa_id";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                Cargo cargo = new Cargo();
                PessoaSalarioConsolidado pessoaSalarioConsolidado = new PessoaSalarioConsolidado();

                pessoa.setId(rs.getInt("pessoa_id"));
                pessoa.setNome(rs.getString("nome_pessoa"));
                cargo.setNome(rs.getString("nome_cargo"));
                
                pessoaSalarioConsolidado.setPessoa(pessoa); 
                pessoaSalarioConsolidado.setCargo(cargo);     
                pessoaSalarioConsolidado.setSalario(rs.getBigDecimal("salario"));

                listaPessoaSalarioConsolidado.add(pessoaSalarioConsolidado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPessoaSalarioConsolidado;
    }
}