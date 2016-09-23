package com.spring.demo;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    SessionFactory sessionFactoryBean;

    void sessionFactoryDemo() {
        String sql = "SELECT COUNT(*) FROM User";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println(query.uniqueResult());

    }

    void printUserNames() throws SQLException {
        String username = "root";
        String password = "mysql";
        Connection connection = dataSource.getConnection(username, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    void userCount() {
        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }

    void getUserName() {
        String sql = "SELECT NAME FROM user WHERE username = ?";
        System.out.println("--->>>>" + jdbcTemplate.queryForObject(sql, new Object[]{"sunny"}, String.class));
    }

    User getUser() {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"sunny"}, new UserMapper());
    }

    void getAllUsers() {
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplate.query(sql, new UserMapper());
        userList.forEach(System.out::println);
    }

    void insertUser(User user) {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(), user.getPassword(), user.getName(), user.getAge(), user.getDob()
        });
    }

    void namedParameterJdbcTemplateDemo() {
        String sql = "SELECT * FROM user WHERE username = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", "sunny");
        System.out.println(namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new UserMapper()));
//        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{"sunny"}));
    }

    void queryForListDemo() {
        String sql = "SELECT * FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));
    }
}
