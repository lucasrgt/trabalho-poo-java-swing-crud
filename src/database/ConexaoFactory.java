package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static Connection conexao;

    private ConexaoFactory() {}

    public Connection getConexaoSingleton() {
        if(conexao == null) {
            try {
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conexao;
    }

}
