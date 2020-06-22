package kr.ac.jejunu.user.DAO;

import kr.ac.jejunu.user.DTO.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PostDao(JdbcTemplate jdbcContext) {
    }

//    @Autowired
//    public UserDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public Post get(Integer id) {
        Object[] params=new Object[]{id};
        String sql="select * from info where id=?";
        return jdbcTemplate.query(sql, params, rs ->{
            Post post=null;
            if(rs.next()){
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDay(rs.getString("day"));
                post.setWriter(rs.getString("writer"));
            }
            return post;
        });
    }

    public void insert(Post post) {
        Object[] params=new Object[]{post.getTitle(), post.getContent(), post.getDay(), post.getWriter()};
        String sql="insert into info (title,content,day,writer) values (?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement;
        },keyHolder);
        post.setId(keyHolder.getKey().intValue());
    }

    public void update(Post post)  {
        Object[] params=new Object[]{post.getTitle(), post.getContent(), post.getId(), post.getDay(), post.getWriter()};
        String sql = "update info set day= ?, title= ? content=? writer=? where id = ?";
        jdbcTemplate.update(sql, params);
    }

    public void delete(Integer id)  {
        Object[] params=new Object[]{id};
        String sql="delete from info where id =?";
        jdbcTemplate.update(sql, params);
    }


}
