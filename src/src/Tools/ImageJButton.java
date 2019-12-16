package src.Tools;

import javax.swing.*;

public class ImageJButton extends JButton {

    public ImageJButton(String buttonText) {
        super(buttonText);
    }

    public void paintBtn(JPanel contentPanel, String imagePath, String imagePressedPath, String imageFocusIcon, int x, int y, int width, int height) {
        setOpaque(false);
        setBorderPainted(false);
        setBounds(x, y, width, height);

        BackgroundIcon backgroundIcon = new BackgroundIcon(imagePath, imagePressedPath, imageFocusIcon, width, height);
        this.setIcon(backgroundIcon.getBackground());

        this.setPressedIcon(backgroundIcon.getBackgroundPressed());
        this.setSelectedIcon(backgroundIcon.getButtonFocusIcon());
        this.setRolloverIcon(backgroundIcon.getButtonFocusIcon());

        contentPanel.add(this);
        // make the Text display on the center of Icon
        setHorizontalTextPosition(JButton.CENTER);
    }
}
