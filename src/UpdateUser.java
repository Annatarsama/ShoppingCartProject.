import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UpdateUser implements AutoCloseable{
    private Connection conn;

    public UpdateUser() {
        this.conn = connect(); // Initialize connection in the constructor
    }
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
    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

    public void updatePassword(String username,String password){
        String sql = "UPDATE Users SET password = ? WHERE username = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,password);
            pstmt.setString(2,username);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Password updated successfully.");
            } else {
                System.out.println("User not found.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void updateEmail(String username,String email){
        String sql = "UPDATE Users SET email = ? WHERE username = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,email);
            pstmt.setString(2,username);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Email updated successfully.");
            } else {
                System.out.println("User not found.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void updateUsername(String email,String username){
        String sql = "UPDATE Users SET username = ? WHERE email = ?";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,email);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Username updated successfully.");
            } else {
                System.out.println("User not found.");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }


}
