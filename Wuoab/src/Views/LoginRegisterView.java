package Views;

import Controllers.LoginRegisterController;
import Tools.BackgroundIcon;
import Tools.ImageJButton;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class LoginRegisterView implements Observer {

    public LoginRegisterView() {
        init();
    }

    public JLabel backgroundLabel;
    public Login login;
    public Register register;

    public void init() {
        JFrame initFrame = new JFrame();
        initFrame.setLayout(null);
        initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame.setBounds(0, 0, 1280, 745);
        initFrame.setLocationRelativeTo(null);
        initFrame.setResizable(false);

        // set background
        BackgroundIcon icon = new BackgroundIcon("src/image/LoginUmbrellaOpen.jpg", 1280, 745);
        backgroundLabel = new JLabel(icon.getBackground());
        backgroundLabel.setBounds(0, 0, 1280, 745);

        // Convert the content pane to a JPanel
        JPanel contentPanel = (JPanel) initFrame.getContentPane();
        contentPanel.setOpaque(false);

        // Add the background image to the bottom of the hierarchical pane as background
        initFrame.getLayeredPane().setLayout(null);
        initFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));

        login = new Login(backgroundLabel, contentPanel);
        initFrame.setVisible(true);

    }

    public void addController(LoginRegisterController controller) {
        login.sign.addMouseListener((MouseListener) controller);
        login.forgetPsw.addMouseListener((MouseListener) controller);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public static class Login extends LoginRegisterView {

        JTextField txtName;
        JPasswordField txtPassword;
        public JLabel sign, forgetPsw;
        ImageJButton btnLogin;

        Login(JLabel backgroundLabel, JPanel contentPanel) {
            backgroundLabel.removeAll();
            BackgroundIcon icon = new BackgroundIcon("src/image/LoginUmbrellaOpen.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());

            // input ID
            txtName = new JTextField(20);
            txtName.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)), " Please input your ID ", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Brush Script Std", 0, 14)));
            txtName.setBounds(440, 280, 400, 65);
            contentPanel.add(txtName);

            // input password
            txtPassword = new JPasswordField(20);
            txtPassword.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)), " Please input your password ", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Brush Script Std", 0, 14)));
            txtPassword.setBounds(440, 370, 400, 65);
            contentPanel.add(txtPassword);
            txtPassword.addFocusListener(new FocusListener() {
                @Override
                public void focusLost(FocusEvent e) {
                    loginUmbrellaOpen(backgroundLabel);
                    contentPanel.revalidate();
                }

                @Override
                public void focusGained(FocusEvent e) {
                    loginUmbrellaClosed(backgroundLabel);
                    contentPanel.revalidate();
                }
            });

            // register link
            sign = new JLabel("Don't have an account?");
            sign.setBounds(445, 460, 200, 20);
            sign.setFont(new java.awt.Font("Brush Script Std", 0, 14));

            contentPanel.add(sign);

            // forget password link
            forgetPsw = new JLabel("I forget the password!");
            forgetPsw.setBounds(445, 484, 200, 20);
            forgetPsw.setFont(new java.awt.Font("Brush Script Std", 0, 14));
            contentPanel.add(forgetPsw);

            // login button
            btnLogin = new ImageJButton(backgroundLabel, "src/ConfirmButtonImage/confirmButton.png",
                    "src/ConfirmButtonImage/confirmPressedButton.png",
                    "src/ConfirmButtonImage/confirmFocusedButton.png",
                    689, 465, 150, 40,
                    "Log In");
            btnLogin.setForeground(Color.WHITE);
            btnLogin.setFont(new java.awt.Font("Brush Script Std", 0, 18));
            contentPanel.add(btnLogin);
        }

        public void loginUmbrellaOpen(JLabel backgroundLabel) {
            BackgroundIcon icon = new BackgroundIcon("src/image/LoginUmbrellaOpen.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());
        }

        public void loginUmbrellaClosed(JLabel backgroundLabel) {
            BackgroundIcon icon = new BackgroundIcon("src/image/LoginUmbrellaClosed.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());
        }

        public JLabel getSign() {
            return sign;
        }


    }

    public class Register {

        JLabel backgroundLabel, label;
        JFrame thePreviousFrame;
        BackgroundIcon icon;
        ImageJButton confirmButton;

        Register(JLabel backgroundLabel, JPanel contentPanel) {
            backgroundLabel.removeAll();
            BackgroundIcon icon = new BackgroundIcon("src/image/Register.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());

            // title
            label = new JLabel("Register in", JLabel.CENTER);
            label.setFont(new java.awt.Font("Brush Script Std", 0, 25));
            label.setBounds(440, 120, 400, 45);
            contentPanel.add(label);

            // register information
            addTextField(backgroundLabel, "Firstname", 440, 180, 150);
            addTextField(backgroundLabel, "Surname", 650, 180, 150);
            addTextField(backgroundLabel, "Password", 440, 230, 400);
            addTextField(backgroundLabel, "Confirm password", 440, 295, 400);
            addTextField(backgroundLabel, "ID Card", 440, 360, 400);
            addTextField(backgroundLabel, "Security question", 440, 360 + 65, 400);
            addTextField(backgroundLabel, "Security answer", 440, 360 + 65 * 2, 400);
            addTextField(backgroundLabel, "Phone number", 440, 360 + 65 * 3, 400);

            // confirm button
            confirmButton = new ImageJButton(backgroundLabel,
                    "src/ConfirmButtonImage/confirmButton.png",
                    "src/ConfirmButtonImage/confirmPressedButton.png",
                    "src/ConfirmButtonImage/confirmFocusedButton.png",
                    560, 360 + 65 * 4, 150, 40,
                    "Confirm");
            confirmButton.setForeground(Color.WHITE);
            confirmButton.setFont(new java.awt.Font("Brush Script Std", 0, 18));

        }

        private void addTextField(JLabel backgroundLabel, String str, int fromTheLeft, int fromTheTop, int width) {
            JTextField txt = new JTextField(20);
            txt.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)),
                    str, TitledBorder.LEFT, TitledBorder.TOP,
                    new java.awt.Font("Brush Script Std", 0, 14)));
            txt.setBounds(fromTheLeft, fromTheTop, width, 55);
            backgroundLabel.add(txt);
        }

    }
}
