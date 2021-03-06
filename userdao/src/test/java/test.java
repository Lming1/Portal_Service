/**
 * Created by iminhyeok on 2018. 3. 16..
 */
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
@SuppressWarnings("Duplicates")
public class test {

    private UserDao userDao;
    private DaoFactory daoFactory;


    @Before
    public void setup(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
//        daoFactory = new DaoFactory();
//        userDao = daoFactory.userDao();
//        ApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:daoFactory.xml");
        userDao = applicationContext.getBean("userDao",UserDao.class);
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
        Integer id = insertUserTest(user);

        User insertedUser = userDao.get(id);
        assertThat(insertedUser.getId(),is(id));
        assertThat(insertedUser.getName(),is(user.getName()));
        assertThat(insertedUser.getPassword(),is(user.getPassword()));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        User user = new User();
        Integer id = insertUserTest(user);

        user.setId(id);
        user.setName("hulk");
        user.setPassword("1234");
        userDao.update(user);

        User updatedUser = userDao.get(id);
        assertThat(updatedUser.getId(), is(user.getId()));
        assertThat(updatedUser.getName(), is(user.getName()));
        assertThat(updatedUser.getPassword(), is(user.getPassword()));
    }

    private Integer insertUserTest(User user) throws ClassNotFoundException, SQLException {
        user.setName("hulk");
        user.setPassword("1111");
        return userDao.insert(user);
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        User user = new User();
        Integer id = insertUserTest(user);

        userDao.delete(id);
        User deletedUser = userDao.get(id);

        assertThat(deletedUser, nullValue());
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

