package kr.ac.jejunu.finalTask;

import java.sql.*;

public class PostManager {
    public Post get(Integer id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/list?serverTimezone=Asia/Seoul",
                "diary","project");

        PreparedStatement preparedStatement=connection.prepareStatement("select * from info where id=?");
        preparedStatement.setInt(1,id);

        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();

        Post post=new Post();
        post.setId(resultSet.getInt("id"));
        post.setDate(resultSet.getString("day"));
        post.setTitle(resultSet.getString("title"));
        post.setContent(resultSet.getString("content"));
        post.setWriter(resultSet.getString("writer"));

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return post;
    }
}
