package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL      = "jdbc:mysql://localhost:3306/hemocentro";
    private static final String USUARIO  = "root";
    private static final String SENHA    = "@Capitaok104864";

    // Metodo estático — qualquer DAO chama ConnectionFactory.getConnection()
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);

    }
}
