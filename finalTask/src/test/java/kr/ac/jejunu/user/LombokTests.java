package kr.ac.jejunu.user;

import kr.ac.jejunu.user.DTO.Post;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LombokTests {
    @Test
    public void  equals(){
        Post user= Post.builder().id(1).name("ye").password("1234").build();
        Post user2= Post.builder().id(1).name("ye").password("1234").build();
        assertThat(user,is(user2));
    }
}
