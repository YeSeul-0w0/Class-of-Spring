package kr.ac.jejunu.user;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao=new UserDao();
        Integer id=1;
        String name="ÇãÁö½Ä";
        String password="1116";
        User user=userDao.get(id);
        assertThat(user.getId(),is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
}
