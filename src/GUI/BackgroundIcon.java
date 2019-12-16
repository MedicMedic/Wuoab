package src.GUI;

import javax.swing.*;
import java.awt.*;

public class BackgroundIcon {

    private ImageIcon backgroundIcon;
    private ImageIcon buttonPressedIcon;
    private ImageIcon buttonFocusIcon;

    public BackgroundIcon(String backgroundIconPath, String buttonPressedIconPath, String buttonFocusIconPath, int width, int height) {
        backgroundIcon = new ImageIcon(backgroundIconPath);
        buttonPressedIcon = new ImageIcon(buttonPressedIconPath);
        buttonFocusIcon = new ImageIcon(buttonFocusIconPath);

        Image image = backgroundIcon.getImage().getScaledInstance(width, height, 1);
        backgroundIcon = new ImageIcon(image);

        image = buttonPressedIcon.getImage().getScaledInstance(width, height, 1);
        buttonPressedIcon = new ImageIcon(image);

        image = buttonFocusIcon.getImage().getScaledInstance(width, height, 1);
        buttonFocusIcon = new ImageIcon(image);
    }

    public BackgroundIcon(String backgroundIconPath, int width, int height) {
        backgroundIcon = new ImageIcon(backgroundIconPath);
        Image image = backgroundIcon.getImage().getScaledInstance(width, height, 1);
        backgroundIcon = new ImageIcon(image);
        
    }

    public ImageIcon getBackground() {
        return this.backgroundIcon;
    }

    public ImageIcon getBackgroundPressed() {
        return this.buttonPressedIcon;
    }

    public ImageIcon getButtonFocusIcon() {
        return this.buttonFocusIcon;
    }
}
