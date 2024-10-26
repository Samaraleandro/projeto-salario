package com.samara.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samara.model.Cargo;
import com.samara.model.CargoVencimentos;
import com.samara.model.Vencimento;

public class CargoVencimentosDAO {
	private Connection connection;

	public CargoVencimentosDAO(Connection connection) {
		this.connection = connection;
	}

	public List<CargoVencimentos> listarTodos() throws SQLException {
		String sql = "SELECT * FROM cargo_vencimentos";
		List<CargoVencimentos> listaCargoVencimentos = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				CargoVencimentos cargoVencimento = new CargoVencimentos();
				cargoVencimento.setId(rs.getInt("id"));

				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("cargo_id"));
				cargoVencimento.setCargo(cargo);

				Vencimento vencimento = new Vencimento();
				vencimento.setId(rs.getInt("vencimento_id"));
				cargoVencimento.setVencimento(vencimento);

				listaCargoVencimentos.add(cargoVencimento);
			}
		}

		return listaCargoVencimentos;
	}

	public CargoVencimentos buscarCargoVencimentosPorId(int id) throws SQLException {
		String sql = "SELECT * FROM cargo_vencimentos WHERE id = ?";
		CargoVencimentos cargoVencimentos = null;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				cargoVencimentos = new CargoVencimentos();
				cargoVencimentos.setId(rs.getInt("id"));

				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("cargo_id"));
				cargoVencimentos.setCargo(cargo);

				Vencimento vencimento = new Vencimento();
				vencimento.setId(rs.getInt("vencimento_id"));
				cargoVencimentos.setVencimento(vencimento);
			}
		}

		return cargoVencimentos;
	}
}