/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.GUI;


import javax.swing.*;
import java.awt.*;

/**
 *
 * @author anthony
 */
public class LoginTemplate extends JFrame {
	// instance field

    public LoginTemplate(){
        String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        this.setBounds(0,0,1280, 745);
        this.setDefaultCloseOperation(new JFrame().EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // set background
        ImageIcon background = new ImageIcon("src/ImageResources/LoginBackground.jpg");
        Image temp = background.getImage().getScaledInstance(1280, 720, 1);
        background = new ImageIcon(temp);
        JLabel backgroundLabel = new JLabel(null, background, 0);

        backgroundLabel.setLayout(null);

//        backgroundLabel.setIcon(background);
        this.add(backgroundLabel);

        JSlider jSlider = new JSlider();
        // Todo: Add your code blow
        ImageJButton test = new ImageJButton(backgroundLabel, "src/ConfirmButtonImages/confirmButton.png", "src/ConfirmButtonImages/confirmPressedButton.png","src/ConfirmButtonImages/confirmFocusedButton.png", 400, 500, 160, 50, "Confirm");
// setVisible should always be shown in the end
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new LoginTemplate();
    }
}
