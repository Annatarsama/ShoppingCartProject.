import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class checkUser {
    private ArrayList<String> userData = new ArrayList<>();
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
    public boolean selectUser(String username, String password){
        String sql = "SELECT * FROM Users WHERE username='"+username+"' AND password='"+password+"'";
        boolean doesUserExists = false;
        try{
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                doesUserExists = true;
                userData.add(rs.getString("name"));
                userData.add(rs.getString("surname"));
                userData.add(rs.getString("username"));
                userData.add(rs.getString("password"));
                userData.add(rs.getString("email"));
            } else {
                doesUserExists = false;
            }
            conn.close();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    return doesUserExists;
    }

    public ArrayList<String> getUserData(){
        return userData;
    }

}
