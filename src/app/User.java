
package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class User {
    protected boolean isLoggedIn;
    private String username;
    private String password;
    App main = new App();
    
    User(String username,String password){
        this.username = username;
        this.password =password;
        
    }
    
    public void logIn(){
            
             String sql = "SELECT * FROM users";
             
             try(Connection conn =main.connect();
                    Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)){
                     
                     while(rs.next()){
                     String username = rs.getString("username");
                     String password = rs.getString("password");
                         
                     
                     if(this.username.equals(username)&& this.password.equals(password)){
                         this.isLoggedIn = true;  
                         
                     } 
                     }
                 
             } catch (SQLException e){
                 System.out.println(e.getMessage());
             }
            
    }
    
    public void register(){
        
    }
    
    
}

