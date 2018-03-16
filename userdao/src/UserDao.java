import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

/**
 * Created by iminhyeok on 2018. 3. 16..
 */
public class UserDao {
    public User get(int id) throws ClassNotFoundException, SQLException{
        //mysql driver load
        Class.forName("com.mysql.jdbc.Driver");
        //connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju","root","");
        //sql write
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id =?");
        preparedStatement.setInt(1,id);
        //sql start
        ResultSet resultSet = preparedStatement.executeQuery();
        //result user mapping
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //res disconnect
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //result return
        return user;
    }
}
