package kr.ac.jejunu.userdao;


import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    String name = "허지식";
    String password = "1116";
    @Test
    public void testJejuGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;

        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        ConnectionMaker connectionMaker=new JejuConnectionMaker();
        userDao = new UserDao(connectionMaker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    public void testJejuInsert() throws SQLException, ClassNotFoundException {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        ConnectionMaker connectionMaker=new JejuConnectionMaker();
        UserDao userDao=new UserDao(connectionMaker);
        userDao.insert(user);
        assertThat(user.getId(),greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));

    }

    public void testHallaGet() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        ConnectionMaker connectionMaker=new HallaConnecntionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    public void testHallaInsert() throws SQLException, ClassNotFoundException {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        ConnectionMaker connectionMaker=new HallaConnecntionMaker();
        UserDao userDao=new UserDao(connectionMaker);
        userDao.insert(user);
        assertThat(user.getId(),greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));

    }
}
