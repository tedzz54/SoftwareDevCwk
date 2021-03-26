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
    
    private static Connection connection = CustomerDatabase.getConnection();
    
    public static void insert(int userID,String userName, String userEmail) {
        
        
        
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
            
        } catch (Exception ex) {
            
            System.out.println("Error while inserting into User table " + ex.getMessage());
            
        }
        
    }
    
    public static ResultSet get(int userID) {
        
      
        
        String sql = "SELECT * FROM User WHERE userID = " + userID;
         ResultSet result = null;
        
        try {
            
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);
            
            if(result.next()){
                System.out.println("Username: " + result.getString("userName"));
                
            }
                
            
            
        } catch (Exception ex) {
            
            System.out.println("Error while reading from User table " + ex.getMessage());
            
        } finally {
        
            return result;
        }
        
        
    }
    
    public static void update(int userID,String userName, String userEmail) {
        
        
        String sql = "UPDATE User SET userName = '" + userName + "', userEmail = '" + userEmail + "' WHERE userID = " + userID;
              
        
        try {
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("User " + userName + " has been updated!");
            
        } catch (Exception ex) {
            
            System.out.println("Error while updating User table " + ex.getMessage());
            
        }
        
    }
    
    
}
