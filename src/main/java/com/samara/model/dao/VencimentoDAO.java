package com.samara.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samara.model.Vencimento;

public class VencimentoDAO {
	private Connection connection;

	public VencimentoDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Vencimento> listarTodos() throws SQLException {
		String sql = "SELECT * FROM vencimento";
		List<Vencimento> listaVencimentos = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Vencimento vencimento = new Vencimento();
				vencimento.setId(rs.getInt("id"));
				vencimento.setDescricao(rs.getString("descricao"));
				vencimento.setTipo(rs.getString("tipo"));
				vencimento.setValor(rs.getDouble("valor"));

				listaVencimentos.add(vencimento);
			}
		}

		return listaVencimentos;
	}

	public Vencimento buscarVencimentoPorId(int id) throws SQLException {
		String sql = "SELECT * FROM vencimentos WHERE id = ?";
		Vencimento vencimento = null;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				vencimento = new Vencimento();
				vencimento.setId(rs.getInt("id"));
				vencimento.setDescricao(rs.getString("descricao"));
				vencimento.setTipo(rs.getString("tipo"));
				vencimento.setValor(rs.getDouble("valor"));
			}
		}

		return vencimento;
	}
}
