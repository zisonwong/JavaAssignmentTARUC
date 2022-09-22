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
            Loginbutton.addActionListener(e ->{  // close loginframe when click login
                LoginFrame.dispose();
            });
            LoginPanel.add(Loginbutton);
            
            success = new JLabel("");   //login successful line or not successful line (can change)
            success.setBounds(200, 120, 300, 25);
            LoginPanel.add(success);
            LoginFrame.dispose();
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
            Product[] products={
                new Product("Shirt",6.00),
                new Product("Pants",5.00)
            };
            JFrame mmFrame = new JFrame();
            JPanel mmPanel = new JPanel();
            mmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mmFrame.setSize(700, 600);
            mmFrame.setLocationRelativeTo(null);
            mmFrame.add(mmPanel);
            mmPanel.setLayout(null);
            mmFrame.setResizable(false);
            mmPanel.setBackground(Color.black);
            
            for(int i =0;i<products.length;i++){
                System.out.println(products[i]);
            }
            
            System.out.println("Product list");
            JButton products1 = new JButton("Shirt  RM6.00");
            mmPanel.add(products1);
            products1.setBounds(0,0,150,100);
            
            JButton products2 = new JButton("Pants  RM7.00");
            mmPanel.add(products2);
            products2.setBounds(0,100,150,100);
            
            JButton products3 = new JButton("Skirt  RM8.00");
            mmPanel.add(products3);
            products3.setBounds(0,200,150,100);
            
            JButton products4 = new JButton("dress  RM9.00");
            mmPanel.add(products4);
            products4.setBounds(0,300,150,100);
            
            JButton products5 = new JButton("man");
            mmPanel.add(products5);
            products5.setBounds(150,0,150,100);
            
            JButton products6 = new JButton("woman");
            mmPanel.add(products6);
            products6.setBounds(150,100,150,100);
            
            JButton products7 = new JButton("Skirt");
            mmPanel.add(products7);
            products7.setBounds(150,200,150,100);
            
            JButton products8 = new JButton("Skirt");
            mmPanel.add(products8);
            products8.setBounds(150,300,150,100);
            
            
            mmFrame.setVisible(true);
//after click pay btn
//dispose
//call method
//jframe(payment)
//print orderlist,subtotal,tax =6%,grandtotal,payment method(cash or card),change,sout(purchase completed),member discount 5%
        }
class Product {
        private String productName;
        private double productPrice;
        
        public Product(){
            this("",0.0);
        }
        
        public Product(String productName,double productPrice) {
            this.productName=productName;
            this.productPrice=productPrice;
        }
        
        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(double productPrice) {
            this.productPrice = productPrice;
        }

        @Override
        public String toString() {
            return "Product{" + "productName=" + productName + ", productPrice=" + productPrice + '}';
        }
        
    }
}




