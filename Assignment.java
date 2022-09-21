/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zison
 */
public class Assignment implements ActionListener {
        private static JLabel userLabel;
        private static JTextField userText;
        private static JLabel passwordLabel;
        private static JPasswordField passwordText;
        private static JButton button;
        private static JLabel success;
    
        JFrame LoginFrame = new JFrame("Login");
        JPanel LoginPanel = new JPanel();
        
Assignment(){
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginFrame.setSize(500, 300);
        
        LoginFrame.setLocationRelativeTo(null);
        LoginFrame.add(LoginPanel);
        LoginPanel.setLayout(null);
        LoginFrame.setResizable(false);
        LoginPanel.setBackground(Color.black);
        
         
        userLabel = new JLabel("User");
        userLabel.setBounds(130, -25, 80, 190);
        userLabel.setForeground(Color.white);
        LoginPanel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(200, 60, 165, 25);
        LoginPanel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(130, -10, 80, 220);
        passwordLabel.setForeground(Color.white);
        LoginPanel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(200, 90, 165, 25);
        LoginPanel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(160, 160, 80, 25);
        button.addActionListener(new Assignment());
        LoginPanel.add(button);
        
        success = new JLabel("");   //login successful line or not successful line (can change)
        success.setBounds(200, 120, 300, 25);
        LoginPanel.add(success);
        LoginFrame.setVisible(true);
    }


@Override
public void actionPerformed(ActionEvent e) {
    String user = userText.getText();
    String password = passwordText.getText();
    System.out.println(user + ", " + password);

        if (user.equals("YuHan") && password.equals("sanikyeh987")) {
            success.setText("Login successful");
            success.setForeground(Color.green);
        } else {
            success.setText("Login unsuccessful");
            success.setForeground(Color.red);
        }
        
         if (userText.getText().isEmpty() && passwordText.getText().isEmpty()){
            success.setText("username and password is empty");
        }          
        else if (userText.getText().isEmpty()){
               success.setText("username is empty");
        }
        else if (passwordText.getText().isEmpty()){
                success.setText("password is empty");
        }
    }
}
    
