/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author yhcha
 */
public class Receipt implements ActionListener {

    private static JLabel user;
    private static JTextField inputID;
    private static JLabel total;
    private static JTextField displayTotal;
    private static JButton click;
    private static JLabel SST;
    private static JTextField displaySST;


    public static void main(String[] args){
        JFrame RCframe = new JFrame("Receipt");
        JPanel RCpanel = new JPanel();

        RCframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RCframe.setSize(500, 300);

        RCframe.setLocationRelativeTo(null);
        RCframe.add(RCpanel);
        RCpanel.setLayout(null);
        RCframe.setResizable(false);
        RCpanel.setBackground(Color.black);

        user = new JLabel("Receipt ID:");
        user.setBounds(7, -75, 80, 190);
        user.setForeground(Color.white);
        RCpanel.add(user);

        inputID = new JTextField();
        inputID.setBounds(70, 10, 165, 25);
        RCpanel.add(inputID);

        SST = new JLabel("SST:");
        SST.setBounds(15, -35, 80, 190);
        SST.setForeground(Color.white);
        RCpanel.add(SST);

        displaySST = new JTextField();
        displaySST.setBounds(70, 50, 165, 25);
        displaySST.setText("6%");
        RCpanel.add(displaySST);

        total = new JLabel("Total:");
        total.setBounds(14, -0, 80, 190);
        total.setForeground(Color.white);
        RCpanel.add(total);

        displayTotal = new JTextField();
        displayTotal.setBounds(70, 90, 165, 25);
        RCpanel.add(displayTotal);

        click = new JButton("Calculate");
        click.setBounds(160, 160, 180, 25);
        click.addActionListener(new Receipt());
        RCpanel.add(click);
        RCframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double temp; 
        double totalAmount;
        
        totalAmount = 10;
        if (totalAmount == 10) {
            temp = totalAmount * 6 / 100;
            displayTotal.setText("RM "+ (totalAmount + temp));
        } else {
            displayTotal.setText("Error");
        }
    }

}

