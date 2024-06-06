package com.example.Library.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
//Creates object and configures it
public class DBConfiguration {


    @Value("${mysql-uri}")
    String uri;
    @Value("${mysql-username}")
    String username;
    @Value("${mysql-password}")
    String password;
    private Connection connection=null;

//    @Bean("mysql")
//    //@Primary
//    public Connection mySQLConnection() {
//        System.out.println("In DB Configuration");
//        //System.out.println(uri+" "+username+" "+password);
//       try{
//           connection= DriverManager.getConnection(uri,username,password);
//       }catch (Exception e){
//           e.printStackTrace();
//       }
//       return connection;
//    }


//    @Bean("oracle")
//    public Connection oracleConnection() {
//        System.out.println("In DB orcale Configuration");
//        try{
//            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","springlearn","K@lyan@1999");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return connection;
//    }
}
