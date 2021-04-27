/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredevcoursework;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author Marcin
 */
public class TrafficDatabaseConnect {
    
 public static Connection getConnection(){
        
        String urlSQLite = "jdbc:sqlite:TrafficDatabase.db";
        
        // Loading up the SQLite Driver
        // Surrounded with try-catch to catch if there any exceptions
        
        try {
            
            Driver driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("SQLite Driver loaded up successfuly!");
            
        } catch (Exception ex) {
            
            System.out.println("There's a problem with the SQLite driver: " + ex.getMessage());
            
        }
        
        // Connecting to the databse again surrounded by try-catch
        // If successfull, it will return the connection to the databse 
        
        Connection connection = null;
        
        try {
            
            connection = DriverManager.getConnection(urlSQLite);
            System.out.println("Connected to the database!");
            
        } catch (Exception ex) {
            
            System.out.println("Error connecting to the database: " + ex.getMessage());
            
        }
        
        return connection;
    }
}
