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
public class Cash implements ActionListener{
    
    
    private static JTextField cashText;
        private static JLabel cashNo;
        private static JButton enterButton;
        
        
        
        JPanel  pCash= new JPanel();
             JFrame fCash = new JFrame();
    
             
             
             
                 public Cash(){
             
            
            fCash.setSize(600,300);
            fCash.setLocationRelativeTo(null);
            fCash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fCash.setTitle("Cash");
            
            pCash.setBackground(Color.black);
            fCash.add(pCash);
             
            pCash.setLayout(null);
             
         
            cashNo = new JLabel("Enter Cash Amount :");
             cashNo.setForeground(Color.white);
             cashNo.setBounds(10,20,200,25);
            pCash.add(cashNo);
             
            cashText = new JTextField(16);
            cashText.setBounds(210,20,300,25);
            pCash.add(cashText);
            
  
            enterButton = new JButton("Enter");
            enterButton.setBounds(250, 120, 80, 25);
            enterButton.addActionListener(this);
            pCash.add(enterButton);
             
             
//            fDebit.setVisible(true);
        }
                 
                 
                  @Override
        public void actionPerformed(ActionEvent e) {
             if( cashText.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Your Input Is Null !!!","Error",JOptionPane.QUESTION_MESSAGE); 
  }
          else if(cashText.getText().matches("[a-zA-Z]+")){
                  JOptionPane.showMessageDialog(null, "Your Input Is Contains Alphabets !!!","Error",JOptionPane.QUESTION_MESSAGE); 
                  cashText.setText("");
                  }
            fCash.dispose();
            
        }
                 
                 
//           if(jcboPayment.getSelectedItem().equals("Cash")){
////           if(jtxtSubTotal.getSelectedText() == null || jtxtDisplay==null){
//  if( jtxtDisplay.getText().equals("")){
//          JOptionPane.showMessageDialog(null, "Your Input Is Null !!!","Error",JOptionPane.QUESTION_MESSAGE); 
//  }
//          else if(jtxtDisplay.getText().matches("[a-zA-Z]+")){
//                  JOptionPane.showMessageDialog(null, "Your Input Is Contains Alphabets !!!","Error",JOptionPane.QUESTION_MESSAGE); 
//                  jtxtDisplay.setText("");
//                  }
//           
//         else{
//           Change();
//            }
//       }
//       else
//               {
//               jtxtChange.setText("");
//               jtxtDisplay.setText("");
//               }
//    
}
