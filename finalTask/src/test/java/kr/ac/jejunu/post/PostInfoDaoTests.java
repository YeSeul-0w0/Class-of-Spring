package kr.ac.jejunu.post;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class PostInfoDaoTests {
    String day="2020-06-14";
    String title="db����";
    String content="���� ������Ʈ�� �ϴ� �߿� ���� ������ �߰��߰� �̸� �ذ��ϱ� ���� 1�ð� ���� ������ ���۸��� �ߴ�.";
    String writer="333";

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
        PostInfo postInfo = postDao.get(id);
        assertThat(postInfo.getId(),is(id));
        assertThat(postInfo.getDay(), is(day));
        assertThat(postInfo.getTitle(), is(title));
        assertThat(postInfo.getContent(), is(content));
        assertThat(postInfo.getWriter(), is(writer));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        PostInfo postInfo =new PostInfo();
        postInfo.setDay(day);
        postInfo.setTitle(title);
        postInfo.setContent(content);
        postInfo.setWriter(writer);
        postDao.insert(postInfo);
        assertThat(postInfo.getId(),greaterThan(0));

        PostInfo insertedPostInfo = postDao.get(postInfo.getId());
        assertThat(insertedPostInfo.getDay(),is(day));
        assertThat(insertedPostInfo.getTitle(), is(title));
        assertThat(insertedPostInfo.getContent(), is(content));
        assertThat(insertedPostInfo.getWriter(), is(writer));
    }

    @Test
    public void update() throws SQLException {
        PostInfo postInfo =new PostInfo();
        postInfo.setDay(day);
        postInfo.setTitle(title);
        postInfo.setContent(content);
        postInfo.setWriter(writer);
        postDao.insert(postInfo);

        String updatedName="Ye";
/*        String updatedPassword="0513";
        postInfo.setName(updatedName);

        postInfo.setPassword(updatedPassword);

        postDao.update(postInfo);

        PostInfo updatePostInfo = postDao.get(postInfo.getId());
        assertThat(updatePostInfo.getName(),is(updatedName));
        assertThat(updatePostInfo.getPassword(),is(updatedPassword));*/
    }
    @Test
    public void delete() throws SQLException {
        PostInfo postInfo =new PostInfo();
        postInfo.setDay(day);
        postInfo.setTitle(title);
        postInfo.setContent(content);
        postInfo.setWriter(writer);

        postDao.insert(postInfo);

        postDao.delete(postInfo.getId());

        PostInfo deletePostInfo = postDao.get(postInfo.getId());

        assertThat(deletePostInfo, IsNull.nullValue());
    }

}
