/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredevcoursework;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author theod
 */
public class userActivityTable {
    
    public static void insert(String userEmail, Timestamp loginTime, Timestamp logoutTime) {
        
        Connection connection = CustomerDatabase.getConnection();
        
        String sql = "INSERT INTO userActivity (userEmail, loginTime, logoutTime) VALUES"
                +"("
                    +"'" + userEmail + "',"
                    +"'" + loginTime + "',"
                    +"'" + logoutTime + "'"
                +")";
        
        try {
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("User activity has been added!");
            connection.close();
            
        } catch (Exception ex) {
            
            System.out.println("Error while inserting into userActivity table " + ex.getMessage());
            
        }
        
    }
    
    public static void update(String userEmail, Timestamp logoutTime) {
        
        Connection connection = CustomerDatabase.getConnection();

        String sql = "UPDATE userActivity SET logoutTime = '" + logoutTime + "' WHERE userEmail = '" + userEmail + "' AND logoutTime = '" + null + "'";
              
        
        try {
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            connection.close();
            
        } catch (Exception ex) {
            
            System.out.println("Error while updating User table " + ex.getMessage());
            
        }
        
    }
    

}
