package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.samara.util.Conexao;

public class SalarioCalculoService {
	public void calcularSalarios() {
		String selectSQL = "SELECT\n" + "    p.id AS pessoa_id,\n" + "    p.nome AS nome_pessoa,\n"
				+ "    c.nome AS nome_cargo,\n"
				+ "    COALESCE(SUM(CASE WHEN v.tipo = 'CREDITO' THEN v.valor END), 0) -\n"
				+ "    COALESCE(SUM(CASE WHEN v.tipo = 'DEBITO' THEN v.valor END), 0) AS salario\n" + "FROM\n"
				+ "    pessoa p\n" + "JOIN\n" + "    cargo c ON p.cargo_id = c.id\n" + "JOIN\n"
				+ "    cargo_vencimentos cv ON c.id = cv.cargo_id\n" + "JOIN\n"
				+ "    vencimento v ON cv.vencimento_id = v.id\n" + "GROUP BY\n" + "    p.id, p.nome, c.nome;";

		String insertSQL = "INSERT INTO pessoa_salario_consolidado (pessoa_id, nome_pessoa, nome_cargo, salario) "
				+ "VALUES (?, ?, ?, ?)";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
				PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
				ResultSet rs = selectStmt.executeQuery()) {

			String deleteSQL = "DELETE FROM pessoa_salario_consolidado";
			try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
				deleteStmt.executeUpdate();
			}

			while (rs.next()) {
				insertStmt.setInt(1, rs.getInt("pessoa_id"));
				insertStmt.setString(2, rs.getString("nome_pessoa"));
				insertStmt.setString(3, rs.getString("nome_cargo"));
				insertStmt.setBigDecimal(4, rs.getBigDecimal("salario"));
				insertStmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
