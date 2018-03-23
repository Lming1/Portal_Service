import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {
//    public ConnectionMaker() {
//    }

    public Connection getConnection() throws ClassNotFoundException, SQLException;

}