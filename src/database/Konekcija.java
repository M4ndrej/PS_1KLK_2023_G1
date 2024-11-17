/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

/**
 *
 * @author Andrej
 */
public class Konekcija {
    
    private static Konekcija instance;
    private Connection connection;
    
    public static Konekcija getInstance(){
        if(instance == null)
            instance = new Konekcija();
        return instance;
    }

    private Konekcija(){
        String url = "jdbc:mysql://localhost:3306/k1_1";
        try{
            connection = DriverManager.getConnection(url,"root","");
            connection.setAutoCommit(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    
}
