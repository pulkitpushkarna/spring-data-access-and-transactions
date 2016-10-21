package com.spring.demo.service;

import org.springframework.stereotype.Service;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserDao {

    public void fetchNamesOfUser() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName).newInstance();
        String connectionString = "jdbc:mysql://localhost:3306/springDemo";
        String username = "root";
        String password = "mysql";
        java.sql.Connection connection = (java.sql.Connection) DriverManager.getConnection(connectionString,
                username, password);
        com.mysql.jdbc.PreparedStatement preparedStatement = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }
}
