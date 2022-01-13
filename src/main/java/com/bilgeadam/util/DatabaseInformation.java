package com.bilgeadam.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class DatabaseInformation {
    private String url;
    private String userName;
    private String userPassword;
    private String forName;

    // parametresiz constructor
    public DatabaseInformation() {
        this.url="jdbc:mysql://localhost:3306/bilgeadam_blog";
        this.userName="root";
        this.userPassword="root";
        this.forName="com.mysql.jdbc.Driver";
    }
//parametreli constructor
    public DatabaseInformation(String url, String userName, String userPassword, String forName) {
        this.url = url;
        this.userName = userName;
        this.userPassword = userPassword;
        this.forName = forName;
    }
}