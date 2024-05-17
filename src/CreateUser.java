import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class CreateUser {
    private Connection connect(){
        String url = "jdbc:sqlite:C:/Users/canug/Desktop/intellij/NewProjects/Users";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void registerUser(String name,String surname,String username,String password,String email){
        String sql = "INSERT INTO Users(name, surname,username,password,email) VALUES(?,?,?,?,?)";
        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,surname);
            pstmt.setString(3,username);
            pstmt.setString(4,password);
            pstmt.setString(5,email);
            pstmt.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e){
            System.out.println("Username or email has already taken");
        }

    }
}
