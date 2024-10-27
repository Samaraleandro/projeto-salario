package com.samara.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samara.model.Cargo;
import com.samara.model.Pessoa;

public class PessoaDAO {
	private Connection connection;

	public PessoaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Pessoa> listarPessoas() throws SQLException {
		List<Pessoa> listaPessoas = new ArrayList<>();
		String sql = "SELECT * FROM pessoa";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCidade(rs.getString("cidade"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setCep(rs.getString("cep"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setPais(rs.getString("pais"));
				pessoa.setUsuario(rs.getString("usuario"));
				pessoa.setTelefone(rs.getString("telefone"));
				pessoa.setDataNascimento(rs.getString("data_nascimento"));

				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("cargo_id"));
				pessoa.setCargo(cargo);

				listaPessoas.add(pessoa);
			}
		}
		return listaPessoas;
	}

	public Pessoa buscarPessoaPorId(int id) throws SQLException {
		String sql = "SELECT * FROM pessoa WHERE id = ?";

		Pessoa pessoa = null;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCidade(rs.getString("cidade"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setCep(rs.getString("cep"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setPais(rs.getString("pais"));
				pessoa.setUsuario(rs.getString("usuario"));
				pessoa.setTelefone(rs.getString("telefone"));
				pessoa.setDataNascimento(rs.getString("data_nascimento"));

				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("cargo_id"));
				pessoa.setCargo(cargo);
			}
		}
		return pessoa;
	}
	
    public void inserirPessoa(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa (nome, cidade, email, cep, endereco, pais, usuario, telefone, data_nascimento, cargo_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCidade());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getCep());
            stmt.setString(5, pessoa.getEndereco());
            stmt.setString(6, pessoa.getPais());
            stmt.setString(7, pessoa.getUsuario());
            stmt.setString(8, pessoa.getTelefone());
            stmt.setString(9, pessoa.getDataNascimento());
            stmt.setInt(10, pessoa.getCargo().getId());

            stmt.executeUpdate();  
        }
    }
	
    public void deletarPessoa(int id) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    public void atualizarPessoa(Pessoa pessoa) throws SQLException {
        String sql = "UPDATE pessoa SET nome = ?, cidade = ?, email = ?, cep = ?, endereco = ?, pais = ?, usuario = ?, telefone = ?, data_nascimento = ?, cargo_id = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCidade());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getCep());
            stmt.setString(5, pessoa.getEndereco());
            stmt.setString(6, pessoa.getPais());
            stmt.setString(7, pessoa.getUsuario());
            stmt.setString(8, pessoa.getTelefone());
            stmt.setString(9, pessoa.getDataNascimento());
            stmt.setInt(10, pessoa.getCargo().getId());
            stmt.setInt(11, pessoa.getId()); 
            
            stmt.executeUpdate();
        }
    }
    
    

}
