/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Assignment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author zison
 */
public class Assignment implements ActionListener{
        private static JLabel userLabel;
        private static JTextField userText;
        private static JLabel passwordLabel;
        private static JPasswordField passwordText;
        private static JButton Loginbutton;
        private static JLabel success;
        
        public static void main(String[] args) {  
            JFrame LoginFrame = new JFrame("Login");
            JPanel LoginPanel = new JPanel();
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

            Loginbutton = new JButton("Login");
            Loginbutton.setBounds(200, 160, 80, 25);
            Loginbutton.addActionListener(new Assignment());
            LoginPanel.add(Loginbutton);
            
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

        if (user.equals("admin") && password.equals("admin123")) {
            success.setText("Login successful");
            success.setForeground(Color.green);
            Mainmenu();
        } 
        else {
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
        public void Mainmenu(){
            JFrame mmFrame = new JFrame();
            mmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mmFrame.setSize(1300, 1000);
            mmFrame.setVisible(true);
        }
}




