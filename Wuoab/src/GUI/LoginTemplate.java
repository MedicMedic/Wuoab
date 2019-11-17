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
        this.setBounds(0,0,1280, 720);
        this.setMinimumSize(this.getSize());
        this.setMaximumSize(this.getSize());
        this.setDefaultCloseOperation(new JFrame().EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // set background
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setLayout(null);
        ImageIcon background = new ImageIcon("LoginBackground.jpg");
        Image temp = background.getImage().getScaledInstance(1280, 720, 1);
        background = new ImageIcon(temp);

        backgroundLabel.setIcon(background);
        this.add(backgroundLabel);


        // Todo: Add your code blow
        ImageJButton test = new ImageJButton(backgroundLabel, "SwipeLeftImage.png", "", 400, 500, 50, 50);
        // setVisible should always be shown in the end
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new LoginTemplate();
    }
}
