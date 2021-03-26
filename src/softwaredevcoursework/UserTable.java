/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredevcoursework;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author theod
 */
public class UserTable {
    
    
    
    public static void insert(int userID,String userName, String userEmail) {
        
        Connection connection = CustomerDatabase.getConnection();
        
        String sql = "INSERT INTO User (userID,userName, userEmail) VALUES"
                +"("
                    +"'" + userID + "',"
                    +"'" + userName + "',"
                    +"'" + userEmail + "'"
                +")";
        
        try {
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("User " + userName + " has been added!");
            connection.close();
            
        } catch (Exception ex) {
            
            System.out.println("Error while inserting into User table " + ex.getMessage());
            
        }
        
    }
    
    public static ResultSet get(String userEmail) {
        
        Connection connection = CustomerDatabase.getConnection();
        
        String sql = "SELECT * FROM User WHERE userEmail = '" + userEmail + "'";
        ResultSet result = null;
        
        try {
            
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);
            connection.close();
            
            
                
            
            
        } catch (Exception ex) {
            
            System.out.println("Error while reading from User table " + ex.getMessage());
            
        } finally {
        
            return result;
        }
        
        
    }
    
    public static void update(int userID,String userName, String userEmail) {
        
        Connection connection = CustomerDatabase.getConnection();
        String sql = "UPDATE User SET userName = '" + userName + "', userEmail = '" + userEmail + "' WHERE userID = " + userID;
              
        
        try {
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("User " + userName + " has been updated!");
            connection.close();
            
        } catch (Exception ex) {
            
            System.out.println("Error while updating User table " + ex.getMessage());
            
        }
        
    }
    
    public static void delete(int userID) {
        
        Connection connection = CustomerDatabase.getConnection();
        String sql = "DELETE FROM User WHERE userID = " + userID;
              
        
        try {
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("User with id: " + userID + " has been deleted!");
            connection.close();
            
        } catch (Exception ex) {
            
            System.out.println("Error while deleteing the user " + ex.getMessage());
            
        }
        
    }
    
    
}
