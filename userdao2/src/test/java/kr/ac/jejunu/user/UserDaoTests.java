package kr.ac.jejunu.user;

import javafx.application.Application;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    String name="ÇãÁö½Ä";
    String password="1116";

    private  static UserDao userDao;

    @BeforeAll
    public static void setup(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("daoFactory.xml");
//        ApplicationContext applicationContext=new GenericGroovyApplicationContext("daoFoactory.groovy");
        userDao =applicationContext.getBean("userDao",UserDao.class);
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Integer id=1;
        User user=userDao.get(id);
        assertThat(user.getId(),is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);
        assertThat(user.getId(),greaterThan(0));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(),is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }

    @Test
    public void update() throws SQLException {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        String updatedName="Ye";
        String updatedPassword="0513";
        user.setName(updatedName);

        user.setPassword(updatedPassword);

        userDao.update(user);

        User updateUser=userDao.get(user.getId());
        assertThat(updateUser.getName(),is(updatedName));
        assertThat(updateUser.getPassword(),is(updatedPassword));
    }
    @Test
    public void delete() throws SQLException {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userDao.insert(user);

        userDao.delete(user.getId());

        User deleteUser=userDao.get(user.getId());

        assertThat(deleteUser, IsNull.nullValue());
    }

}
