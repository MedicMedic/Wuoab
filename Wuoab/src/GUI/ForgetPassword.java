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
    JFrame thePreviousFrame;
    JLabel backgroundLabel;
    BackgroundIcon icon;

    public ForgetPassword(JFrame thePreviousFrame) {
        this.thePreviousFrame = thePreviousFrame;
        this.setBounds(0, 0, 1280, 745);
        this.setDefaultCloseOperation(new JFrame().EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // set background two
        backgroundLabel = new JLabel();
        backgroundLabel.setLayout(null);
        icon = new BackgroundIcon("src/image/ForgetPassword.jpg", 1280, 720);
        backgroundLabel.setIcon(icon.getBackground());
        this.add(backgroundLabel);

        // Todo: Add your code blow
        JLabel label = new JLabel("Confirm your account", JLabel.CENTER);
        label.setFont(new java.awt.Font("Brush Script Std", 0, 27));
        label.setForeground(Color.gray);
        label.setBounds(440, 280, 400, 45);
        backgroundLabel.add(label);

        addTextField(backgroundLabel, " Please input you account ", 350);
//the Button
        ImageJButton confirmButton = new ImageJButton(backgroundLabel,
                "src/ConfirmButtonImages/confirmButton.png",
                "src/ConfirmButtonImages/confirmPressedButton.png",
                "src/ConfirmButtonImages/confirmFocusedButton.png",
                560, 450, 160, 50,
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
                ImageIcon background = new ImageIcon("src/image/ResetPassword.jpg");
                Image temp = background.getImage().getScaledInstance(1280, 720, 1);
                background = new ImageIcon(temp);
                createInputLabel(backgroundLabel, background);
            }
        });
// setVisible should always be shown in the end
        this.setVisible(true);
    }

    /**
     * @param foundationJLabel is the aim JLabel as a container
     *
     * @param backgroundimage is the picture of the backgound, its format is
     * ImageIcon ,it is used in JLabel.setIcon();
     *
     */
    private void createInputLabel(JLabel foundationJLabel, ImageIcon backgroundimage) {

        foundationJLabel.setIcon(backgroundimage);
        JLabel label = new JLabel("Reset your password", JLabel.CENTER);
        label.setFont(new java.awt.Font("Brush Script Std", 0, 25));
        label.setBounds(440, 180, 400, 45);
        foundationJLabel.add(label);

        addTextField(foundationJLabel, " Security question ", 245);
        addTextField(foundationJLabel, " Security answer ", 245 + 75);
        addTextField(foundationJLabel, " New password ", 245 + 75 * 2);
        addTextField(foundationJLabel, " Confirm password ", 245 + 75 * 3);

        ImageJButton confirmButton = new ImageJButton(foundationJLabel,
                "src/ConfirmButtonImages/confirmButton.png",
                "src/ConfirmButtonImages/confirmPressedButton.png",
                "src/ConfirmButtonImages/confirmFocusedButton.png",
                560, 245 + 75 * 4, 160, 50,
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
                //clear the old components
                foundationJLabel.removeAll();
                icon = new BackgroundIcon("src/image/ForgetPassword.jpg", 1280, 720);
                createSuccessInfo(foundationJLabel, icon.getBackground());
            }
        });
    }

    private void createSuccessInfo(JLabel foundationJLabel, ImageIcon backgroundimage) {
        foundationJLabel.setIcon(backgroundimage);
        // Todo: Add your code blow
        JLabel label = new JLabel("Reset successfully ！", JLabel.CENTER);
        label.setFont(new java.awt.Font("Brush Script Std", 0, 27));
        label.setBounds(440, 350, 400, 45);
        foundationJLabel.add(label);
//the Button
        ImageJButton confirmButton = new ImageJButton(foundationJLabel,
                "src/ConfirmButtonImages/confirmButton.png",
                "src/ConfirmButtonImages/confirmPressedButton.png",
                "src/ConfirmButtonImages/confirmFocusedButton.png",
                560, 430, 160, 50,
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
                foundationJLabel.removeAll();
                //foundationJLabel
                gotoLogin();
            }
        });
    }

    /**
     * go to Login todo
     */
    private void gotoLogin() {
        dispose();
        thePreviousFrame.setVisible(true);
    }

    private void addTextField(JLabel foudatonJLabel, String nameString, int height) {
        JTextField txtAccount = new JTextField(20);
        txtAccount.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)),
                nameString, TitledBorder.LEFT, TitledBorder.TOP,
                new java.awt.Font("Brush Script Std", 0, 14)));
        txtAccount.setBounds(440, height, 400, 55);
        foudatonJLabel.add(txtAccount);
    }

//    public static void main(String[] args) {
////        new ForgetPassword();
//    }
}
