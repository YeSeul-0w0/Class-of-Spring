package kr.ac.jejunu.user;

import kr.ac.jejunu.user.DTO.Post;
import kr.ac.jejunu.user.DAO.PostDao;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class PostDaoTests {
    String name="ÇãÁö½Ä";
    String password="1116";

    private  static PostDao postDao;

    @BeforeAll
    public static void setup(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("kr.ac.jejunu.user");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("daoFactory.xml");
//        ApplicationContext applicationContext=new GenericGroovyApplicationContext("daoFoactory.groovy");
        postDao =applicationContext.getBean("userDao", PostDao.class);
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Integer id=1;
        Post user= postDao.get(id);
        assertThat(user.getId(),is(id));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        Post user=new Post();
        postDao.insert(user);
        assertThat(user.getId(),greaterThan(0));

        Post insertedUser = postDao.get(user.getId());

    }

    @Test
    public void update() throws SQLException {
        Post user=new Post();
        postDao.insert(user);

        String updatedName="Ye";
        String updatedPassword="0513";

        postDao.update(user);

        Post updateUser= postDao.get(user.getId());
    }
    @Test
    public void delete() throws SQLException {
        Post user=new Post();
        postDao.insert(user);

        postDao.delete(user.getId());

        Post deleteUser= postDao.get(user.getId());

        assertThat(deleteUser, IsNull.nullValue());
    }

}
