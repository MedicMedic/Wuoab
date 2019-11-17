/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

/**
 *
 * @author anthony
 */
public class ForgetPassword extends JFrame {
	// instance field

    public ForgetPassword(){
        this.setBounds(0,0,1280, 745);
        this.setDefaultCloseOperation(new JFrame().EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // set background two
        ImageIcon background = new ImageIcon("src/image/重置密码.jpg");
        Image temp = background.getImage().getScaledInstance(1280, 720, 1);
        background = new ImageIcon(temp);
        
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setLayout(null);
        ImageIcon background2 = new ImageIcon("src/image/忘记密码.jpg");
         temp = background2.getImage().getScaledInstance(1280, 720, 1);
        background2 = new ImageIcon(temp);

        backgroundLabel.setIcon(background2);
        this.add(backgroundLabel);


        // Todo: Add your code blow
        JLabel label =new JLabel("Confirm your account",JLabel.CENTER);
        label.setFont(new java.awt.Font("Brush Script Std", 0, 25));
        label.setBounds(440, 280, 400, 45);
        backgroundLabel.add(label);
        
        
        
// setVisible should always be shown in the end
        this.setVisible(true);
    }
    
    private void createInputLabel(JLabel foundationJLabel){
        JLabel label =new JLabel("Reset your password",JLabel.CENTER);
        label.setFont(new java.awt.Font("Brush Script Std", 0, 25));
        label.setBounds(440, 180, 400, 45);
        foundationJLabel.add(label);
        
        addTextField(foundationJLabel, " Security question ", 245);
        addTextField(foundationJLabel, " Security question ", 245+75);
        addTextField(foundationJLabel, " Security question ", 245+75*2);
        addTextField(foundationJLabel, " Security question ", 245+75*3);
        
        
        ImageJButton confirmButton = new ImageJButton(foundationJLabel, 
                "src/ConfirmButtonImage/confirmButton.png",
                "src/ConfirmButtonImage/confirmPressedButton.png",
                "src/ConfirmButtonImage/confirmFocusedButton.png", 
                560, 245+75*4, 160, 50, 
                "Confirm");
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new java.awt.Font("Brush Script Std", 0, 18));
        
        confirmButton.addActionListener(new ActionListener(){
            
             /**
             * Invoked when an action occurs.
             *
             * @param e create map
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

        private void addTextField(JLabel foudatonJLabel,String nameString,int height){
        JTextField txtAccount = new JTextField(20);
        txtAccount.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)), 
                nameString, TitledBorder.LEFT, TitledBorder.TOP, 
                new java.awt.Font("Brush Script Std", 0, 14)));
        txtAccount.setBounds(440, height, 400, 55);
        foudatonJLabel.add(txtAccount);
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
