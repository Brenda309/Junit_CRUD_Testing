import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    String dbURL = "jdbc:postgresql://localhost:5432/student";
    String username = "postgres";
    String pass = "Whatwhat4321!";

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(dbURL,username,pass);
            return connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;
    }

}
