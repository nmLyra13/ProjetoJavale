package br.com.vale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
	public boolean verificarLogin(String nome, String senha) {
		String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
		try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, nome);
			stmt.setString(2, senha);

			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next(); // Se houver um resultado, login está correto
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
