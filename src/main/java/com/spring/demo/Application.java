package com.spring.demo;

import com.spring.demo.service.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        userDao.fetchNamesOfUser();
    }
}
