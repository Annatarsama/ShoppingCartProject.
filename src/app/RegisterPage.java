/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author canug
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton goToLoginButton; // New button to go to the login page

    public RegisterPage() {
        setTitle("Register Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform registration process here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Example: Print out the entered username and password
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                // Here you would typically save the username and password to a database or file
            }
        });

        goToLoginButton = new JButton("Go to Login");
        goToLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the login page
                dispose(); // Close the current registration page
               // new LoginPage(); // Open the login page
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(goToLoginButton); // Add the new button to the panel

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegisterPage();
            }
        });
    }
}
