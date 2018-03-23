import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

/**
 * Created by iminhyeok on 2018. 3. 16..
 */
public class UserDao {
    private final ConnectionMaker connectionMaker = new JejuConnectionMaker();

    public User get(int id) throws ClassNotFoundException, SQLException {

        Connection connection = connectionMaker.getConnection();
        //sql write
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id =?");
        preparedStatement.setInt(1, id);
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



    public Integer insert(User user) throws ClassNotFoundException, SQLException {
        //mysql driver load
        Connection connection = connectionMaker.getConnection();
        //sql write
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name, password) values(?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        //result user mapping
        resultSet.next();
        Integer id = resultSet.getInt(1);
        //res disconnect
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //result return
        return id;
    }
//
//    public Connection getConnection() throws ClassNotFoundException, SQLException{
//        return connectionMaker.getConnection();
//    }
}
