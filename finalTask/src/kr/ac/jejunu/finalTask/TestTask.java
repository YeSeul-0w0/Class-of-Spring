package kr.ac.jejunu.finalTask;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestTask {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Integer id=1;
        String date="2020-06-14";
        String title="db오류";
        String content="포털 프로젝트를 하는 중에 권한 에러를 발견했고 이를 해결하기 위해 1시간 동안 열심히 구글링을 했다.";
        String writer="333";
        PostManager postManager=new PostManager();
        Post post=postManager.get(id);
        assertThat(post.getId(), Is.is(id));
        assertThat(post.getDate(), Is.is(date));
        assertThat(post.getTitle(), Is.is(title));
        assertThat(post.getContent(), Is.is(content));
        assertThat(post.getWriter(), Is.is(writer));
    }
}
