package com.bilgeadam.util;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class DatabaseConnection  extends  DatabaseInformation{

    //Singleton Design pattern
    private static  DatabaseConnection instance;

    //database connection
    private Connection connection;

    //Database connection information
    private String url=this.getUrl();
    private String userName=this.getUserName();
    private String userPassword=this.getUserPassword();



    //S.DP.private constructor
    private DatabaseConnection() {
        try {
            Class.forName(this.getForName());
            System.out.println("Driver Success !!!");
            log.info("Driver Success !!!");
            this.connection= DriverManager.getConnection(url,userName,userPassword);
            log.info("Connection Success ... !!!");
        }catch (Exception e){
            System.out.println("!!! Error Connection failed ");
            e.printStackTrace();
        }
    }

    //amaçım eğer bağlantı varsa onu kullanmak
    //eğer bağlantı kapatılmış veya bağlantı yoksa instance yapmak
    public static DatabaseConnection getInstance() {
        try {
            if(instance==null)
                instance=new DatabaseConnection();
            else if(instance.connection.isClosed())
                instance=new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    //getConnection
    public Connection getConnection() {
        return connection;
    }

    public DatabaseConnection setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection=new DatabaseConnection();
    }

}