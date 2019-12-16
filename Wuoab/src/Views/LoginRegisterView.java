package Views;

import Controllers.LoginRegisterController;
import Tools.BackgroundIcon;
import Tools.ImageJButton;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class LoginRegisterView implements Observer {

    JLabel backgroundLabel;
    JPanel contentPanel;
    JFrame initFrame;
    Login login;
    Register register;
    ForgetPsw forgetPsw;
    ResetPsw resetPsw;
    ResetPswSuccessfully resetPswSuccessfully;

    public LoginRegisterView() {
        login = new Login();
        register = new Register();
        forgetPsw = new ForgetPsw();
        resetPsw = new ResetPsw();
        resetPswSuccessfully = new ResetPswSuccessfully();
        paintInitialization();
    }

    public void paintInitialization() {
        initFrame = new JFrame();
        initFrame.setLayout(null);
        initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame.setBounds(0, 0, 1280, 745);
        initFrame.setLocationRelativeTo(null);
        initFrame.setResizable(false);

        // set background
        BackgroundIcon icon = new BackgroundIcon("src/LoginRegisterImages/LoginBackground.jpg", 1280, 745);
        backgroundLabel = new JLabel(icon.getBackground());
        backgroundLabel.setBounds(0, 0, 1280, 745);

        // Convert the content pane to a JPanel
        contentPanel = (JPanel) initFrame.getContentPane();
        contentPanel.setOpaque(false);

        // Add the background image to the bottom of the hierarchical pane as background
        initFrame.getLayeredPane().setLayout(null);
        initFrame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));

        login.paintLogin(backgroundLabel, contentPanel);
        initFrame.setVisible(true);
    }

    public Login getLogin() {
        return login;
    }

    public Register getRegister() {
        return register;
    }

    public ForgetPsw getForgetPsw() {
        return forgetPsw;
    }

    public ResetPsw getResetPsw() {
        return resetPsw;
    }

    public ResetPswSuccessfully getResetPswSuccessfully() {
        return resetPswSuccessfully;
    }

    public JLabel getBackgroundLabel() {
        return backgroundLabel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void addController(LoginRegisterController controller) {
        // Login
        login.getConfirmButton().addActionListener(controller);
        // 去注册流程
        login.getSign().addMouseListener(controller);//跳转到注册界面
        register.getConfirmButton().addActionListener(controller);//回到登录界面

        // 忘记密码流程
        login.getForgetPsw().addMouseListener(controller);//跳转到忘记密码界面
        forgetPsw.getConfirmButton().addActionListener(controller);//跳转到重置密码界面
        resetPsw.getConfirmButton().addActionListener(controller);//跳转到重置成功界面
        resetPswSuccessfully.getConfirmButton().addActionListener(controller);//回到登录界面
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public class Login {

        JTextField uuid;
        JPasswordField txtPassword;
        JLabel sign, forgetPsw;
        ImageJButton btnLogin;
        
        public Login(){
            sign = new JLabel("Don't have an account?");
            forgetPsw = new JLabel("I forget the password!");
        }

        public void paintLogin(JLabel backgroundLabel, JPanel contentPanel) {
            backgroundLabel.removeAll();
            contentPanel.removeAll();
            BackgroundIcon icon = new BackgroundIcon("src/LoginRegisterImages/LoginUmbrellaOpen.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());

            // input ID
            uuid = new JTextField(20);
            uuid.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)), " Please input your ID ", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Brush Script Std", 0, 14)));
            uuid.setBounds(440, 280, 400, 65);
            contentPanel.add(uuid);

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
            sign.setBounds(445, 460, 200, 20);
            sign.setFont(new java.awt.Font("Brush Script Std", 0, 14));
            contentPanel.add(sign);

            // forget password link
            forgetPsw.setBounds(445, 484, 200, 20);
            forgetPsw.setFont(new java.awt.Font("Brush Script Std", 0, 14));
            contentPanel.add(forgetPsw);

            // login button
            btnLogin = new ImageJButton("Confirm");
            btnLogin.paintBtn(contentPanel, "src/ConfirmButtonImages/confirmButton.png",
                    "src/ConfirmButtonImages/confirmPressedButton.png",
                    "src/ConfirmButtonImages/confirmFocusedButton.png",
                    689, 465, 150, 40);
            btnLogin.setForeground(Color.WHITE);
            btnLogin.setFont(new java.awt.Font("Brush Script Std", 0, 18));
            contentPanel.add(btnLogin);

        }

        public JLabel getSign() {
            return sign;
        }

        public JLabel getForgetPsw() {
            return forgetPsw;
        }

        public ImageJButton getConfirmButton() {
            return btnLogin;
        }

        public JTextField getUuid() {
            return uuid;
        }

        public JPasswordField getTxtPassword() {
            return txtPassword;
        }

        public void loginUmbrellaOpen(JLabel backgroundLabel) {
            BackgroundIcon icon = new BackgroundIcon("src/LoginRegisterImages/LoginUmbrellaOpen.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());
        }

        public void loginUmbrellaClosed(JLabel backgroundLabel) {
            BackgroundIcon icon = new BackgroundIcon("src/LoginRegisterImages/LoginUmbrellaClosed.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());
        }
    }

    public class Register {

        JLabel title;
        ImageJButton confirmButton;

        public Register() {
            confirmButton = new ImageJButton("Confirm");
        }

        public void paintRegister(JLabel backgroundLabel, JPanel contentPanel) {
            backgroundLabel.removeAll();
            contentPanel.removeAll();
            BackgroundIcon icon = new BackgroundIcon("src/LoginRegisterImages/Register.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());

            // title
            title = new JLabel("Register in", JLabel.CENTER);
            title.setFont(new java.awt.Font("Brush Script Std", 0, 25));
            title.setBounds(440, 120, 400, 45);
            contentPanel.add(title);

            // register information
            addTextField(contentPanel, "Firstname", 440, 175, 187);
            addTextField(contentPanel, "Surname", 651, 175, 187);
            addTextField(contentPanel, "Password", 440, 240, 400);
            addTextField(contentPanel, "Confirm password", 440, 305, 400);
            addTextField(contentPanel, "ID Card", 440, 370, 400);
            addTextField(contentPanel, "Security question", 440, 370 + 65, 400);
            addTextField(contentPanel, "Security answer", 440, 370 + 65 * 2, 400);
            addTextField(contentPanel, "Phone number", 440, 370 + 65 * 3, 400);

            // confirm button
            confirmButton.paintBtn(contentPanel,
                    "src/ConfirmButtonImages/confirmButton.png",
                    "src/ConfirmButtonImages/confirmPressedButton.png",
                    "src/ConfirmButtonImages/confirmFocusedButton.png",
                    560, 370 + 65 * 4, 150, 40);
            confirmButton.setForeground(Color.WHITE);
            confirmButton.setFont(new java.awt.Font("Brush Script Std", 0, 18));

        }

        public ImageJButton getConfirmButton() {

            return confirmButton;
        }

    }

    public class ForgetPsw {

        JLabel title;
        ImageJButton confirmButton;

        public ForgetPsw() {
            confirmButton = new ImageJButton("Confirm");
        }

        public void paintForgetPsw(JLabel backgroundLabel, JPanel contentPanel) {
            backgroundLabel.removeAll();
            contentPanel.removeAll();
            BackgroundIcon icon = new BackgroundIcon("src/LoginRegisterImages/ForgetPassword.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());

            // title
            title = new JLabel("Confirm your account", JLabel.CENTER);
            title.setFont(new java.awt.Font("Brush Script Std", 0, 27));
            title.setForeground(Color.gray);
            title.setBounds(440, 280, 400, 45);
            contentPanel.add(title);

            // input
            addTextField(contentPanel, " Please input you account ", 440, 350, 400);

            // confirm button
            confirmButton.paintBtn(contentPanel,
                    "src/ConfirmButtonImages/confirmButton.png",
                    "src/ConfirmButtonImages/confirmPressedButton.png",
                    "src/ConfirmButtonImages/confirmFocusedButton.png",
                    560, 450, 160, 50);
            confirmButton.setForeground(Color.WHITE);
            confirmButton.setFont(new java.awt.Font("Brush Script Std", 0, 18));
        }

        public ImageJButton getConfirmButton() {
            return confirmButton;
        }
    }

    public class ResetPsw {

        JLabel title;
        ImageJButton confirmButton;

        public ResetPsw() {
            confirmButton = new ImageJButton("Confirm");
        }

        public void paintResetPsw(JLabel backgroundLabel, JPanel contentPanel) {
            backgroundLabel.removeAll();
            contentPanel.removeAll();
            BackgroundIcon icon = new BackgroundIcon("src/LoginRegisterImages/ResetPassword.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());

            // title
            title = new JLabel("Reset your password", JLabel.CENTER);
            title.setFont(new java.awt.Font("Brush Script Std", 0, 25));
            title.setBounds(440, 180, 400, 45);
            contentPanel.add(title);

            // input
            addTextField(contentPanel, " Security question ", 440, 245, 400);
            addTextField(contentPanel, " Security answer ", 440, 245 + 75, 400);
            addTextField(contentPanel, " New password ", 440, 245 + 75 * 2, 400);
            addTextField(contentPanel, " Confirm password ", 440, 245 + 75 * 3, 400);

            // confirm button
            confirmButton.paintBtn(contentPanel,
                    "src/ConfirmButtonImages/confirmButton.png",
                    "src/ConfirmButtonImages/confirmPressedButton.png",
                    "src/ConfirmButtonImages/confirmFocusedButton.png",
                    560, 245 + 75 * 4, 160, 50);
            confirmButton.setForeground(Color.WHITE);
            confirmButton.setFont(new java.awt.Font("Brush Script Std", 0, 18));

        }

        public ImageJButton getConfirmButton() {
            return confirmButton;
        }
    }

    public class ResetPswSuccessfully {

        JLabel info;
        ImageJButton confirmButton;

        public ResetPswSuccessfully() {
            confirmButton = new ImageJButton("Confirm");
        }

        public void paintResetPswSuccessfully(JLabel backgroundLabel, JPanel contentPanel) {
            backgroundLabel.removeAll();
            contentPanel.removeAll();
            BackgroundIcon icon = new BackgroundIcon("src/LoginRegisterImages/ForgetPassword.jpg", 1280, 745);
            backgroundLabel.setIcon(icon.getBackground());

            // success information
            info = new JLabel("Reset successfully ！", JLabel.CENTER);
            info.setFont(new java.awt.Font("Brush Script Std", 0, 27));
            info.setBounds(440, 350, 400, 45);
            contentPanel.add(info);

            // confirm button
            confirmButton.paintBtn(contentPanel,
                    "src/ConfirmButtonImages/confirmButton.png",
                    "src/ConfirmButtonImages/confirmPressedButton.png",
                    "src/ConfirmButtonImages/confirmFocusedButton.png",
                    560, 430, 160, 50);
            confirmButton.setForeground(Color.WHITE);
            confirmButton.setFont(new java.awt.Font("Brush Script Std", 0, 18));
        }

        public ImageJButton getConfirmButton() {
            return confirmButton;
        }
    }

    public void addTextField(JPanel contentPanel, String str, int fromTheLeft, int fromTheTop, int width) {
        JTextField txt = new JTextField(20);
        txt.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)),
                str, TitledBorder.LEFT, TitledBorder.TOP,
                new java.awt.Font("Brush Script Std", 0, 14)));
        txt.setBounds(fromTheLeft, fromTheTop, width, 55);
        contentPanel.add(txt);
    }
}
