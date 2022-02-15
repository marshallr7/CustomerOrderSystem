package xyz.marshalldev.User;

import javax.swing.*;

public class User {
    private int id;
    private String password;
    private String securityQuestion;
    private String answer;

    public void create() {
        JTextField id = new JTextField();
        JTextField password = new JPasswordField();
        JTextField question = new JTextField();
        JTextField answer = new JTextField();
        Object[] message = {
                "ID:", id,
                "Password:", password,
                "Security Question:", question,
                "Answer:", answer
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            if (id.getText() != null && password.getText() != null && question.getText() != null && answer.getText() != null) {
                User user = new User();
                user.setId(Integer.parseInt(id.getText()));
                user.setPassword(password.getText());
                user.setSecurityQuestion(question.getText());
                user.setAnswer(answer.getText());
                UserCache.getInstance().addUser(user);
            } else {
                create();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\nPassword: " + this.password + "\nSecurity Question: " + this.securityQuestion + "\nAnswer:" + this.answer;
    }
}
