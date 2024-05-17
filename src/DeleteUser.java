import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteUser {
    private Connection connect(){
        String url = "jdbc:sqlite:C:/Users/canug/Desktop/intellij/NewProjects/Users";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void deleteUser(String username,String password){
        String sql = "DELETE FROM Users WHERE username = ? AND password =?";
        try{
            Connection conn= this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            int deletedUser = pstmt.executeUpdate();
            if(deletedUser > 0){
                System.out.println("User "+ username+" has deleted");
            } else {
                System.out.println("There is no user with such username and password");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
