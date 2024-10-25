package com.samara.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samara.model.Cargo;

public class CargoDAO {
	private Connection connection;


    public CargoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<Cargo> listarTodos() throws SQLException {
        String sql = "SELECT id, nome FROM cargo";
        List<Cargo> listaCargos = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt("id"));
                cargo.setNome(rs.getString("nome"));
                listaCargos.add(cargo);
            }
        }

        return listaCargos;
    }
    
    public Cargo buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nome FROM cargo WHERE id = ?";
        Cargo cargo = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cargo = new Cargo();
                cargo.setId(rs.getInt("id"));
                cargo.setNome(rs.getString("nome"));
            }
        }

        return cargo;
    }
}
