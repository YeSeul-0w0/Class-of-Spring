package kr.ac.jejunu.user;

import java.sql.*;

public class UserDao {
    public User get(Integer id) throws ClassNotFoundException, SQLException {
        // 데이터는 어디에 있지? → mysql에 존재
        // mysql driver 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        // connection 맺기
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju?serverTimezone=Asia/Seoul", "jeju", "jejupw");
        // query 만들기
        PreparedStatement preparedStatement=connection.prepareStatement("select id, name, password from userinfo where id=?");
        preparedStatement.setInt(1, id);
        // query 실행
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        // 결과를 User 매핑
        User user=new User();
        user.setId(resultSet.getInt("id"));
        user.setName((resultSet.getString("name")));
        user.setPassword(resultSet.getString("password"));
        // 자원해지
        resultSet.close();
        preparedStatement.close();
        connection.close();
        // 결과 return
        return user;
    }
}
