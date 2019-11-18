package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Login extends JFrame {

    private JLabel backgroundLabel;
    private JPanel contentPanel;//内容窗格（在背景上的各种组件）
    private JLayeredPane layerPanel;
    private Dimension screenSize;//获取屏幕的分辨率
    private JTextField txtName;//用户名框
    private JPasswordField txtPassword;//密码框
    private JLabel sign;//注册链接
    private JLabel forgetPsw;//忘记密码链接
    private JButton btnLogin;//登录按钮
    private JFrame theLoginFrame;

    public Login() {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1280, 745);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // 背景图片
        ImageIcon background1 = new ImageIcon("src/ImageResources/MainPage1.jpg");
        Image temp1 = background1.getImage().getScaledInstance(1280, 745, 1);
        background1 = new ImageIcon(temp1);
        backgroundLabel = new JLabel(background1);
        backgroundLabel.setBounds(0, 0, 1280, 745);

        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        contentPanel = (JPanel) this.getContentPane();
        contentPanel.setOpaque(false);

        // 把背景图片添加到分层窗格的最底层作为背景
        layerPanel = this.getLayeredPane();
        this.getLayeredPane().setLayout(null);
        this.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));

        container();

        this.setVisible(true);
        theLoginFrame=this;
    }

    public void init_background1(JLabel foundationJlabel) {   //雨伞张开
        // 背景图片
        ImageIcon background = new ImageIcon("src/ImageResources/MainPage1.jpg");
        Image temp1 = background.getImage().getScaledInstance(1280, 745, 1);
        background = new ImageIcon(temp1);
        foundationJlabel.setIcon(background);
    }

    public void init_background2(JLabel foundationJlabel) {   //雨伞合上
        ImageIcon background2 = new ImageIcon("src/ImageResources/MainPage2.jpg");
        Image temp1 = background2.getImage().getScaledInstance(1280, 745, 1);
        background2 = new ImageIcon(temp1);
        foundationJlabel.setIcon(background2);
    }

    public void container() {

        // txt姓名
        txtName = new JTextField(20);
        txtName.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)), " Please enter your account number ", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Brush Script Std", 0, 14)));
        txtName.setBounds(440, 280, 400, 65);
        contentPanel.add(txtName);

        // txt密码
        txtPassword = new JPasswordField(20);
        txtPassword.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(137, 175, 220)), " Please input a password ", TitledBorder.LEFT, TitledBorder.TOP, new java.awt.Font("Brush Script Std", 0, 14)));
        txtPassword.setBounds(440, 370, 400, 65);
        contentPanel.add(txtPassword);
        txtPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("hi");
                init_background1(backgroundLabel);
                contentPanel.revalidate();
            }

            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("hello");
                init_background2(backgroundLabel);
                contentPanel.revalidate();
            }
        });

        //跳转到注册页面
        sign = new JLabel("Don't have an account?");
        sign.setBounds(445, 460, 200, 20);
        sign.setFont(new java.awt.Font("Brush Script Std", 0, 14));
        contentPanel.add(sign);

        sign.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new CreateAccount(theLoginFrame);
            }
        });

        //跳转到忘记密码页面
        forgetPsw = new JLabel("I forget the password!");
        forgetPsw.setBounds(445, 484, 200, 20);
        forgetPsw.setFont(new java.awt.Font("Brush Script Std", 0, 14));
        contentPanel.add(forgetPsw);
        forgetPsw.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new ForgetPassword(theLoginFrame);
            }
        });

        // btn登录
        btnLogin = new JButton("Log In");
        btnLogin.setBackground(new Color(137, 175, 220));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new java.awt.Font("Brush Script Std", 0, 18));
        btnLogin.setBorderPainted(false);
        btnLogin.setBounds(689, 465, 150, 40);
        contentPanel.add(btnLogin);
    }

    public static void main(String[] args) {
        new Login();
    }

}
