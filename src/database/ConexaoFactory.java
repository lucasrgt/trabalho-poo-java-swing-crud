package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/java_crud_swing";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection conexao;

    public ConexaoFactory() {}

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
