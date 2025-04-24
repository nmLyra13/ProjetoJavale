package br.com.vale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	private static final String URL = "jdbc:postgresql://localhost:5432/lancamentos_db";
	private static final String USER = "postgres";
	private static final String PASSWORD = "123456";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
	}
}
