package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        UserDAO userDAO = applicationContext.getBean(UserDAO.class);
        userDAO.queryForListDemo();
//        System.out.println(userDAO.getUser());
//        userDAO.sessionFactoryDemo();
//        User user=new User();
//        user.setUsername("abc");
//        user.setPassword("abc");
//        user.setName("abc");
//        user.setAge(25);
//        user.setDob(new Date());
//        userDAO.insertUser(user);
    }
}
