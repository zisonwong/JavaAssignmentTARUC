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
public class DebitCard implements ActionListener{
     private static JTextField debitText,cvvText;
        private static JLabel debitNo,cvvNo;
        private static JButton enterButton;
        
        
        
        JPanel  pDebit= new JPanel();
             JFrame fDebit = new JFrame();
             
             
             
//                public static void main(String[] args) {
//            // String input = "4716589858188195";
//            DebitCard debitCard = new DebitCard();
//            // System.out.println(validateDebitCardNumber(userInput()));
//    }
        
        public DebitCard(){
             
            
            fDebit.setSize(600,300);
            fDebit.setLocationRelativeTo(null);
            fDebit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fDebit.setTitle("Debit Card");
            
            pDebit.setBackground(Color.black);
            fDebit.add(pDebit);
             
            pDebit.setLayout(null);
             
         
            debitNo = new JLabel("Enter Your Debit Number :");
            debitNo.setForeground(Color.white);
            debitNo.setBounds(10,20,200,25);
            pDebit.add(debitNo);
             
            debitText = new JTextField(16);
            debitText.setBounds(210,20,300,25);
            pDebit.add(debitText);
            
            
            //display security code
            cvvNo = new JLabel("Enter Your (CVV) :");
            cvvNo.setForeground(Color.white);
            cvvNo.setBounds(10,60,200,25);
            pDebit.add(cvvNo);
             
            cvvText = new JTextField(16);
            cvvText.setBounds(210,60,300,25);
            pDebit.add(cvvText);
            
             
            enterButton = new JButton("Enter");
            enterButton.setBounds(250, 120, 80, 25);
            enterButton.addActionListener(this);
            pDebit.add(enterButton);
             
             
//            fDebit.setVisible(true);
        }
        
          private static boolean validateDebitCardNumber(String input){
        int[] debitNo = new int[input.length()];
        
        for(int i = 0; i<input.length();i++){
            debitNo[i] = Integer.parseInt(input.substring(i,i+1));
        }
        
        for(int i = debitNo.length - 2;i>=0;i=i-2){
            int temp = debitNo[i];
            temp = temp * 2;
            if(temp > 9){
                temp = temp % 10+1;
            }
            
            debitNo[i] = temp;
        }
        
        int total=0;
        for(int i =0;i <debitNo.length;i++){
            total += debitNo[i];
        }
        if(total % 10 == 0){
            return true;   
        }else    
            return false;
    }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean validDebit,validCvv;
            String num,cvv;
            
          
            
                       do{
                          
               num = debitText.getText();
              validDebit = num.matches("[0-9]+");
              
          if(num.length() != 16 || validDebit == false){
               JOptionPane.showMessageDialog(null, "Invalid Number, Please enter again !","Error",JOptionPane.WARNING_MESSAGE);        
                 num= JOptionPane.showInputDialog("Re-enter your Debit Card Number:");
             debitText.setText(num);
          }
           
           }while(num.length() != 16 || validDebit == false);
           //System.out.println(validateDebitCardNumber(num));
           
           
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

           if (validateDebitCardNumber(num) == true){
                JOptionPane.showMessageDialog(null, "Transaction Completed","Congrats",JOptionPane.QUESTION_MESSAGE);  
           }else{
                JOptionPane.showMessageDialog(null, "Transaction Failed","Error",JOptionPane.WARNING_MESSAGE);  
                new DebitCard();
           }
            fDebit.dispose();
    }
       
       

        
       
        
        }

