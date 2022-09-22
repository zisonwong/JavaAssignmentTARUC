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
public class Payment implements ActionListener{
        private static JButton Button1,Button2,Button3;
        private static JLabel selectButton;
          
             JPanel  pButton= new JPanel();
             JFrame fButton = new JFrame();
          
            CreditCard Credit =new CreditCard();
            DebitCard Debit = new DebitCard();
            Cash cash = new Cash();
            
            
               public static void main(String[] args) {
                Payment pay = new Payment();
                pay.fButton.setVisible(true);   
                 }
            
            
            
            Payment(){
            fButton.setSize(600,290);
            fButton.setLocationRelativeTo(null);
            fButton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fButton.setTitle("Payment Method");
            
            pButton.setBackground(Color.black);
            fButton.add(pButton);
             
            pButton.setLayout(null);
             
            selectButton = new JLabel("Select Payment Method");
            selectButton.setForeground(Color.white);
            selectButton.setFont(new Font("Comic Sans MS",Font.BOLD,25));
            selectButton.setBounds(160,25,350,25);
            pButton.add(selectButton);
            
            
            Button1 = new JButton("Cash");
            Button1.setBounds(80, 70, 120, 150);
            Button1.addActionListener(this);
            pButton.add(Button1);
            
             Button2 = new JButton("Credit Card");
            Button2.setBounds(250, 70, 120, 150);
            Button2.addActionListener(this);
            pButton.add(Button2);
            
             Button3 = new JButton("Debit Card");
            Button3.setBounds(420, 70, 120, 150);
            Button3.addActionListener(this);
            pButton.add(Button3);
             
             
           
            
            
           }
               
          
            
            
            @Override
        public void actionPerformed(ActionEvent e) {
           Object pay = e.getSource();
           
           
           
          if(pay==Button1)
              cash.fCash.setVisible(true);
          else  if(pay==Button2)
                Credit.fCredit.setVisible(true);
           else  if(pay==Button3)
                Debit.fDebit.setVisible(true);
           
        fButton.dispose();
        
        
        }
//               int select;
//                Scanner scan = new Scanner(System.in);
//               select = scan.nextInt();
//               
//                  
//               if(select == 1)
//                    new CreditCard();
//               else
//              new ButtonCard();
               
  
    
    
    
}
