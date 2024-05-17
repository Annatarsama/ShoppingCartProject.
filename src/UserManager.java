import java.util.ArrayList;


public class UserManager extends User{





    public UserManager(String name, String surname, String username, String password, String email) {
        super(name, surname, username, password, email);
    }


    @Override
    public void register(String name, String surname,String username, String password, String email) {
        //Creating user
        CreateUser app = new CreateUser();
        app.registerUser(name,surname,username,password,email);
    }

    public void logout(){
        didLogin= false;
        setName("");
        setSurname("");
        setUsername("");
        setPassword("");
        setEmail("");

    }

    @Override
    public void login(String username, String password) {
        ArrayList<String> userData;
        checkUser app = new checkUser();
        didLogin = app.selectUser(username,password);

        if(didLogin){
            System.out.println("You've logged in successfully");
            userData = app.getUserData();
            setName(userData.get(0));
            setSurname(userData.get(1));
            setUsername(userData.get(2));
            setPassword(userData.get(3));
            setEmail(userData.get(4));
        } else {
            System.out.println("Password or username is wrong");
        }
    }

    @Override
    public void updateUsername(String email, String newUsername) {
        if(didLogin){
            UpdateUser app = new UpdateUser();
            app.updateUsername(email,newUsername);
        } else {
            System.out.println("you have to login before making any changes");
        }
    }


    @Override
    public void updatePassword(String username, String newPassword) {

        if(didLogin){
            UpdateUser app = new UpdateUser();
            app.updatePassword(username,newPassword);
        } else {
            System.out.println("you have to login before making any changes");
        }
    }

    @Override
    public void updateEmail(String username,String newEmail){
        if(didLogin){
            UpdateUser app = new UpdateUser();
            app.updateEmail(username,newEmail);
        } else {
            System.out.println("you have to login before making any changes");
        }
    }

    @Override
    public void deleteAccount(String username, String password) {
        if(didLogin){
            DeleteUser app = new DeleteUser();
            app.deleteUser(username,password);
        } else {
            System.out.println("You have to login before making any changes");
        }
    }
}
