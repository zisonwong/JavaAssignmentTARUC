/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validatecard;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dickie
 */
public class CreditCard implements ActionListener {

    
    
    
    
        private static JTextField creditText,cvvText;
        private static JLabel creditNo,cvvNo;
        private static JButton enterButton;
        
        
        
        JPanel  pCredit= new JPanel();
             JFrame fCredit = new JFrame();
             
             
             
//                public static void main(String[] args) {
//            // String input = "4716589858188195";
//            CreditCard creditCard = new CreditCard();
//            // System.out.println(validateCreditCardNumber(userInput()));
//    }
        
        public CreditCard(){
             
            
            fCredit.setSize(600,300);
            fCredit.setLocationRelativeTo(null);
            fCredit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fCredit.setTitle("Credit Card");
            
            pCredit.setBackground(Color.black);
            fCredit.add(pCredit);
             
            pCredit.setLayout(null);
             
         
            creditNo = new JLabel("Enter Your Credit Number :");
            creditNo.setForeground(Color.white);
            creditNo.setBounds(10,20,200,25);
            pCredit.add(creditNo);
             
            creditText = new JTextField(16);
            creditText.setBounds(210,20,300,25);
            pCredit.add(creditText);
            
            
            //display security code
            cvvNo = new JLabel("Enter Your (CVV) :");
            cvvNo.setForeground(Color.white);
            cvvNo.setBounds(10,60,200,25);
            pCredit.add(cvvNo);
             
            cvvText = new JTextField(16);
            cvvText.setBounds(210,60,300,25);
            pCredit.add(cvvText);
            
             
            enterButton = new JButton("Enter");
            enterButton.setBounds(250, 120, 80, 25);
            enterButton.addActionListener(this);
            pCredit.add(enterButton);
             
             
//            fCredit.setVisible(true);
        }
        
          private static boolean validateCreditCardNumber(String input){
        int[] creditNo = new int[input.length()];
        
        for(int i = 0; i<input.length();i++){
            creditNo[i] = Integer.parseInt(input.substring(i,i+1));
        }
        
        for(int i = creditNo.length - 2;i>=0;i=i-2){
            int temp = creditNo[i];
            temp = temp * 2;
            if(temp > 9){
                temp = temp % 10+1;
            }
            
            creditNo[i] = temp;
        }
        
        int total=0;
        for(int i =0;i <creditNo.length;i++){
            total += creditNo[i];
        }
        if(total % 10 == 0){
            return true;   
        }else    
            return false;
    }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean validCredit,validCvv;
            String num,cvv;
            
          
            
                       do{
                          
               num = creditText.getText();
              validCredit = num.matches("[0-9]+");
              
          if(num.length() != 16 || validCredit == false){
               JOptionPane.showMessageDialog(null, "Invalid Number, Please enter again !","Error",JOptionPane.WARNING_MESSAGE);        
                 num= JOptionPane.showInputDialog("Re-enter your Credit Card Number:");
             creditText.setText(num);
          }
           
           }while(num.length() != 16 || validCredit == false);
           //System.out.println(validateCreditCardNumber(num));
           
           
             cvv = cvvText.getText();
           if(cvv.length()!= 3){
             do{
            cvv = cvvText.getText();
             validCvv = cvv.matches("[0-9]+");
            if(cvv.length() != 3 || validCvv == false){
                JOptionPane.showMessageDialog(null, "Invalid CVV, Please enter again !","Error",JOptionPane.WARNING_MESSAGE);    
                cvv = JOptionPane.showInputDialog("Re-enter your CVV Number:");
                cvvText.setText(cvv);
            }
            }while(cvv.length() != 3 || validCvv == false);
           }

           if (validateCreditCardNumber(num) == true){
                JOptionPane.showMessageDialog(null, "Transaction Completed","Congrats",JOptionPane.QUESTION_MESSAGE);  
                
           }else{
                JOptionPane.showMessageDialog(null, "Transaction Failed, Please Try Again","Error",JOptionPane.WARNING_MESSAGE);  
                new CreditCard();
           }
             fCredit.dispose();
    }

  
        
       

        
       
        
        }
        
        
     
      
//        private static String userInput(){
//        
//           Scanner scan = new Scanner(System.in);
//            boolean validCredit;
//            String num;
//           do{
//        System.out.println("Enter Credit Card Number:");
//               num=scan.next();
//              validCredit = num.matches("[0-9]+");
//              
//          if(num.length() == 16 && validCredit == true){
//              System.out.println("Valid Number");
//             
//          }else{
//              System.out.println("Invalid Number, Please enter again !");
//             
//          }
//           }while(num.length() != 16 || validCredit == false);
//           return num;
//    }
//    
//    private static boolean validateCreditCardNumber(String input){
//        int[] creditNo = new int[input.length()];
//        
//        for(int i = 0; i<input.length();i++){
//            creditNo[i] = Integer.parseInt(input.substring(i,i+1));
//        }
//        
//        for(int i = creditNo.length - 2;i>=0;i=i-2){
//            int temp = creditNo[i];
//            temp = temp * 2;
//            if(temp > 9){
//                temp = temp % 10+1;
//            }
//            
//            creditNo[i] = temp;
//        }
//        
//        int total=0;
//        for(int i =0;i <creditNo.length;i++){
//            total += creditNo[i];
//        }
//        if(total % 10 == 0){
//            return true;
//        }else 
//            return false;
//    }

