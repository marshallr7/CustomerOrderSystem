package xyz.marshalldev;

import javax.swing.*;

public class GUI {
    JTextField id = new JTextField();
    JTextField password = new JPasswordField();
    JTextField answer = new JTextField();
    JTextField name = new JTextField();
    JTextField address = new JTextField();
    JTextField cardNumber = new JTextField();


    public int login() {
        Object[] message = {
                "ID: ", id,
                "Password: ", password,
        };

        return JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
    }

}
