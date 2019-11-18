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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.TitledBorder;

/**
 *
 * @author anthony
 */
public class CreateAccount extends JFrame {
    // instance field

    JFrame thePreviousFrame;

    public CreateAccount(JFrame one) {
        this.thePreviousFrame=one;
        this.setBounds(0, 0, 1280, 745);
        this.setDefaultCloseOperation(new JFrame().EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // set background
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setLayout(null);
        ImageIcon background = new ImageIcon("src/image/注册.jpg");
        Image temp = background.getImage().getScaledInstance(1280, 720, 1);
        background = new ImageIcon(temp);

        backgroundLabel.setIcon(background);
        this.add(backgroundLabel);

        // Todo: Add your code blow
        JLabel label = new JLabel("Register in", JLabel.CENTER);
        label.setFont(new java.awt.Font("Brush Script Std", 0, 25));
        label.setBounds(440, 120, 400, 45);
        backgroundLabel.add(label);
        //Account 
        addTextField(backgroundLabel, "Account", 165);
        //Password+65
        addTextField(backgroundLabel, "Password", 230);
        addTextField(backgroundLabel, "Confirm password", 295);
        addTextField(backgroundLabel, "ID Card", 360);
        addTextField(backgroundLabel, "Security question", 360 + 65);
        addTextField(backgroundLabel, "Security answer", 360 + 65 * 2);
        addTextField(backgroundLabel, "Phone number", 360 + 65 * 3);
        //confirm button
        ImageJButton confirmButton = new ImageJButton(backgroundLabel,
                "src/ConfirmButtonImage/confirmButton.png",
                "src/ConfirmButtonImage/confirmPressedButton.png",
                "src/ConfirmButtonImage/confirmFocusedButton.png",
                560, 360 + 65 * 4, 150, 40,
                "Confirm");
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new java.awt.Font("Brush Script Std", 0, 18));

        confirmButton.addActionListener(new ActionListener() {

            /**
             * Invoked when an action occurs.
             *
             * @param e create map
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                backgroundLabel.removeAll();
                ImageIcon background = new ImageIcon("src/image/忘记密码.jpg");
                Image temp = background.getImage().getScaledInstance(1280, 720, 1);
                background = new ImageIcon(temp);
                createSuccessInfo(backgroundLabel, background, thePreviousFrame);
            }
        });

// setVisible should always be shown in the end
        this.setVisible(true);
    }

    private void addTextField(JLabel foudatonJLabel, String nameString, int height) {
        JTextField txtAccount = new JTextField(20);
        txtAccount.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)),
                nameString, TitledBorder.LEFT, TitledBorder.TOP,
                new java.awt.Font("Brush Script Std", 0, 14)));
        txtAccount.setBounds(440, height, 400, 55);
        foudatonJLabel.add(txtAccount);
    }

    private void createSuccessInfo(JLabel foundationJLabel, ImageIcon backgroundimage, JFrame thePrevious) {
        foundationJLabel.setIcon(backgroundimage);
        // Todo: Add your code blow
        JLabel label = new JLabel("Account create success ！", JLabel.CENTER);
        label.setFont(new java.awt.Font("Brush Script Std", 0, 27));
        label.setBounds(440, 350, 400, 45);
        foundationJLabel.add(label);
//the Button
        ImageJButton confirmButton = new ImageJButton(foundationJLabel,
                "src/ConfirmButtonImage/confirmButton.png",
                "src/ConfirmButtonImage/confirmPressedButton.png",
                "src/ConfirmButtonImage/confirmFocusedButton.png",
                560, 430, 160, 50,
                "Go to log in");
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new java.awt.Font("Brush Script Std", 0, 18));

        confirmButton.addActionListener(new ActionListener() {

            /**
             * Invoked when an action occurs.
             *
             * @param e create map
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                thePrevious.setVisible(true);
            }
        });
    }

//    public static void main(String[] args) {
////          new CreateAccount();
//    }
}
