import java.sql.*;

/**
 * Created by iminhyeok on 2018. 3. 16..
 */
public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(int id) throws  SQLException {

        String sql = "select * from user where id =?";
        Object[] params = new Object[]{id};
        return jdbcContext.queryForObject(sql, params);
    }

    public Integer insert(User user) throws  SQLException {

        String sql = "insert into user(name, password) values (?, ?)";
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        return jdbcContext.insert(sql, params);
    }


    public void update(User user) throws SQLException {

        String sql = "update user set name = ?, password = ? where id = ?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcContext.update(sql, params);
    }


    public void delete(Integer id) throws SQLException {
        String sql = "delete from user where id = ?";
        Object[] params = new Object[]{id};
        jdbcContext.update(sql, params);
    }

}
