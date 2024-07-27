package org.Main;

import org.Controller.ControllerLogin;
import org.View.Login;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        ControllerLogin cl = new ControllerLogin(login);
    }
}