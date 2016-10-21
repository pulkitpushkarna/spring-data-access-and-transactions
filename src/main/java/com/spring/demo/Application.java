package com.spring.demo;


import com.spring.demo.service.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        userDao.dummy();
    }
}
