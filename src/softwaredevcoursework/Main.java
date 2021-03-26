/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwaredevcoursework;
import java.sql.ResultSet;

/**
 *
 * @author theod
 */
public class Main {

    
    public static void main(String[] args) {
        Tables.createUser();
       
        UserTable.update(0, "Theodor", "theodoriliasi@outlook.com");

        
    }
    
}
