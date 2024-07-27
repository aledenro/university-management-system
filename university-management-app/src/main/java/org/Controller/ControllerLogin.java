package org.Controller;

import org.Model.ModelLogin;
import org.View.Login;
import org.View.MainMenu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class ControllerLogin implements MouseListener {
    Login login;
    String correo = "";
    String contrasena = "";

    public ControllerLogin(Login login) {
        this.login = login;
        this.login.getBtnLogin().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.login.getBtnLogin()){
            btnLoginClicked();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void getValuesCorreoContrasena(){
        this.correo = this.login.getTxtCorreo().getText();
        this.contrasena = this.login.getTxtContrasena().getText();
    }

    private void btnLoginClicked(){
        getValuesCorreoContrasena();
        if (correo.isEmpty()){
            JOptionPane.showMessageDialog(this.login, "Debe llenar el campo del correo.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else if (contrasena.isEmpty()){
            JOptionPane.showMessageDialog(this.login, "Debe llenar el campo de contraseña.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ModelLogin loginLogic = new ModelLogin();
        String resultadoLogin = loginLogic.loginLogic(correo, contrasena);

        if(resultadoLogin.isEmpty()){
            this.login.setVisible(false);
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            MainMenuController mainMenuController = new MainMenuController(mainMenu);
        }else {
            JOptionPane.showMessageDialog(this.login, resultadoLogin, "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }
}
