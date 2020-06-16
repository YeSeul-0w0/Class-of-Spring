package kr.ac.jejunu.post;

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


    public PostInfo get(Integer id) {
        Object[] params=new Object[]{id};
        String sql="select * from info where id=?";
        return jdbcTemplate.query(sql, params, rs ->{
            PostInfo postInfo =null;
            if(rs.next()){
                postInfo = new PostInfo();
                postInfo.setId(rs.getInt("id"));
                postInfo.setDay(rs.getString("day"));
                postInfo.setTitle(rs.getString("title"));
                postInfo.setContent(rs.getString("content"));
                postInfo.setWriter(rs.getString("writer"));
            }
            return postInfo;
        });
    }

    public void insert(PostInfo postInfo) {
        Object[] params=new Object[]{postInfo.getTitle(), postInfo.getContent()};
        String sql="insert into info (name,password) values (?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement;
        },keyHolder);
        postInfo.setId(keyHolder.getKey().intValue());
    }

    public void update(PostInfo postInfo)  {
        Object[] params=new Object[]{postInfo.getId(),postInfo.getDay(), postInfo.getTitle(), postInfo.getContent(), postInfo.getWriter()};
        String sql = "update info set name= ?, password= ? where id = ?";
        jdbcTemplate.update(sql, params);
    }

    public void delete(Integer id)  {
        Object[] params=new Object[]{id};
        String sql="delete from userinfo where id =?";
        jdbcTemplate.update(sql, params);
    }


}
