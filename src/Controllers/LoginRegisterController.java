package src.Controllers;

import src.Models.LoginRegisterModel;
import src.Views.LoginRegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginRegisterController implements ActionListener, MouseListener {

    LoginRegisterModel model;
    LoginRegisterView view;

    public void addModel(LoginRegisterModel model) {
        this.model = model;
    }

    public void addView(LoginRegisterView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getRegister().getConfirmButton()) {
            view.getLogin().paintLogin(view.getBackgroundLabel(), view.getContentPanel());
        }
        else if(e.getSource() == view.getForgetPsw().getConfirmButton()){
            view.getResetPsw().paintResetPsw(view.getBackgroundLabel(), view.getContentPanel());
        }
        else if(e.getSource() == view.getResetPsw().getConfirmButton()){
            view.getResetPswSuccessfully().paintResetPswSuccessfully(view.getBackgroundLabel(), view.getContentPanel());
        }
        else if(e.getSource() == view.getResetPswSuccessfully().getConfirmButton()){
            view.getLogin().paintLogin(view.getBackgroundLabel(), view.getContentPanel());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == view.getLogin().getSign()) {
            view.getRegister().paintRegister(view.getBackgroundLabel(), view.getContentPanel());
        } 
        else if (e.getSource() == view.getLogin().getForgetPsw()) {
            view.getForgetPsw().paintForgetPsw(view.getBackgroundLabel(), view.getContentPanel());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
