package GUI;

import javax.swing.*;
import java.awt.*;

public class BackgroundIcon{
    private ImageIcon backgroundIcon;
    private ImageIcon buttonPressedIcon;
    public BackgroundIcon(String backgroundIconPath, String buttonPressedIconpath, int width, int height){
        backgroundIcon = new ImageIcon(backgroundIconPath);
        buttonPressedIcon = new ImageIcon(buttonPressedIconpath);
        Image image = backgroundIcon.getImage().getScaledInstance(width, height, 1);
        backgroundIcon = new ImageIcon(image);

        image = buttonPressedIcon.getImage().getScaledInstance(width, height, 1);
        buttonPressedIcon = new ImageIcon(image);
    }

    public BackgroundIcon(String backgroundIconPath, int width, int height) {
    backgroundIcon = new ImageIcon(backgroundIconPath);
    Image image = backgroundIcon.getImage().getScaledInstance(width, height, 1);
    backgroundIcon = new ImageIcon(image);
  }

    public ImageIcon getBackground(){
        return this.backgroundIcon;
    }
    public ImageIcon getBackgroundPressed(){
        return this.buttonPressedIcon;
    }
}

