package com.example.wishproject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DatabaseConnectionManager
    {
        //variabler
        private static String hostname;
        private static String username;
        private static String password;
        private static Connection conn;

        //metoder
        public static Connection getConnection()
        {
            hostname = "wishlistdatabasekea.mysql.database.azure.com";
            username = "MEM";
            password = "Databasesjov12345";

            try
            {
                conn = DriverManager.getConnection(hostname, username, password);
            }
            catch (SQLException e){
                System.out.println("connection to database failed!");
                throw new RuntimeException(e);
            }
            System.out.println("connection to database successfull ");
            return conn;
        }
    }
