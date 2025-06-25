package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:sqlite:biblioteca.db";

    // Cria e retorna a conexão com a base de dados SQLite
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados.");
            return null;
        }
    }
}