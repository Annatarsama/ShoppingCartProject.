/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.*;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        
            //connect();
            App app = new App();
            app.selectAll();
            
            //for registerpage
           /* SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RegisterPage registerPage = new RegisterPage(); // Create an instance of the RegisterPage
            }
        });
           */
           User user1 = new User("enes","merhaba");
           user1.logIn();
           System.out.println(user1.isLoggedIn);
    }
  
    
     public void selectAll(){
             String sql = "SELECT * FROM users";
             
             try(Connection conn = connect();
                    Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)){
                 
            //Loop users
                 while(rs.next()){
                     System.out.println(rs.getInt("id")+ "\t" +rs.getString("username"));
                 }
             } catch (SQLException e){
                 System.out.println(e.getMessage());
             }
            }
     
     //easiest way to connect database
     public Connection connect(){
         String url = "jdbc:sqlite:C:/Users/canug/Desktop/app/Users.db";
         Connection conn = null;
         try{
             conn = DriverManager.getConnection(url);
         } catch(SQLException e){
             System.out.println(e.getMessage());
         }
         return conn;
     }
}
