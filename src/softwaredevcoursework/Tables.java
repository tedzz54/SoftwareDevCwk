/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredevcoursework;
import java.sql.Connection;
import java.sql.Statement;


public class Tables {
   
    public static void createUser(){
        
        // Creating the User table with the coresponding columns 
        
        Connection connection = CustomerDatabase.getConnection();
        
        String sql = "CREATE TABLE if not exists User"
                +"("
                    +"userID INTEGER PRIMARY KEY,"
                    +"userName VARCHAR (50),"
                    +"userEmail VARCHAR (50)"  
                +")";
        
        // Using a try-catch to catch if there are any erros when creating the table
        // And if there are any then display the error message 
        
        try {
            
            Statement sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(sql);
            System.out.println("User table created successfully!");
            
        } catch (Exception ex) {
            
            System.out.println("Error creating User table!" + ex.getMessage());
        }
        
    }
    
//    public static void createUserActivity(){
//        
//        // Creating the User table with the coresponding columns 
//        
//        Connection connection = CustomerDatabase.getConnection();
//        String sql = "CREATE TABLE if not exists userActivity"
//                +"("
//                    +"userEmail VARCHAR,"
//                    +"loginTime TIME"
//                    +"logout TIME"
//                +")";
//        
//        // Using a try-catch to catch if there are any erros when creating the table
//        // And if there are any then display the error message 
//        
//        try {
//            
//            Statement sqlStatement = connection.createStatement();
//            sqlStatement.executeUpdate(sql);
//            System.out.println("UserActivity table created successfully!");
//            
//        } catch (Exception ex) {
//            
//            System.out.println("Error creating UserActivity table!" + ex.getMessage());
//        }
//        
//    }
    
}
