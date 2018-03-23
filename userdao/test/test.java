/**
 * Created by iminhyeok on 2018. 3. 16..
 */
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.sql.SQLException;
@SuppressWarnings("Duplicates")
public class test {

    private UserDao userDao;

    @Before
    public void setup(){
        userDao = new UserDao();

    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id= 1;
        User user = userDao.get(id);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));

    }
    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("hulk");
        user.setPassword("1111");
        Integer id = userDao.insert(user);

        User insertedUser = userDao.get(id);
        assertThat(insertedUser.getId(),is(id));
        assertThat(insertedUser.getName(),is(user.getName()));
        assertThat(insertedUser.getPassword(),is(user.getPassword()));
    }
//    @Test
//    public void hallaGet() throws SQLException, ClassNotFoundException {
//        int id= 1;
//        User user = hallaUserDao.get(id);
//        assertThat(user.getId(), is(1));
//        assertThat(user.getName(), is("허윤호"));
//        assertThat(user.getPassword(), is("1234"));
//
//    }
//    @Test
//    public void hallaAdd() throws SQLException, ClassNotFoundException {
//        User user = new User();
//        user.setName("hulk");
//        user.setPassword("1111");
//        Integer id = hallaUserDao.insert(user);
//
//        User insertedUser = hallaUserDao.get(id);
//        assertThat(insertedUser.getId(),is(id));
//        assertThat(insertedUser.getName(),is(user.getName()));
//        assertThat(insertedUser.getPassword(),is(user.getPassword()));
//    }
 }

