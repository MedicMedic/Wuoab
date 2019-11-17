/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javax.swing.*;
import java.awt.*;

/**
 *
 * @author anthony
 */
public class LoginTemplate extends JFrame {
	// instance field

    public LoginTemplate(){
        this.setBounds(0,0,1280, 745);
        this.setDefaultCloseOperation(new JFrame().EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // set background
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setLayout(null);
        ImageIcon background = new ImageIcon("src/ImageResources/LoginBackground.jpg");
        Image temp = background.getImage().getScaledInstance(1280, 720, 1);
        background = new ImageIcon(temp);

        backgroundLabel.setIcon(background);
        this.add(backgroundLabel);


        // Todo: Add your code blow
        ImageJButton test = new ImageJButton(backgroundLabel, "src/ConfirmButtonImage/confirmButton.png", "src/ConfirmButtonImage/confirmPressedButton.png","src/ConfirmButtonImage/confirmFocusedButton.png", 400, 500, 160, 50, "Confirm");
        // setVisible should always be shown in the end
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new LoginTemplate();
    }
}
