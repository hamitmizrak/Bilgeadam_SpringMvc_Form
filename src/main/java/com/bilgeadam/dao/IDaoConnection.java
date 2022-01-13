package com.bilgeadam.dao;

import com.bilgeadam.util.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDaoConnection<T> {

    //CRUD
    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public ArrayList<T> list();

    //Connection
    default Connection getInterfaceConnection(){
        return DatabaseConnection.getInstance().getConnection();
    }
}