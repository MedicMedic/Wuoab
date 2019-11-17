package GUI;

import javax.swing.*;

class ImageJButton extends JButton {

   ImageJButton(JLabel backgroundLabel, String imagePath, String imagePressedPath, int x, int y, int width, int height){
      super();

      setOpaque(false);
      setBorderPainted(false);
      setBounds(x, y, width, height);

      BackgroundIcon backgroundIcon = new BackgroundIcon(imagePath, imagePressedPath, width, height);
      this.setIcon(backgroundIcon.getBackground());

      this.setPressedIcon(backgroundIcon.getBackgroundPressed());
//      this.setDisabledIcon(backgroundIcon.getBackgroundPressed());

      backgroundLabel.add(this);
      // make the Text display on the center of Icon
      setHorizontalTextPosition(JButton.CENTER);

   }
}

