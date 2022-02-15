package xyz.marshalldev;

public class User {
    private int id;
    private String password;
    private String securityQuestion;
    private String answer;

    public User(int id, String password, String securityQuestion, String answer) {
        this.id = id;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.answer = answer;
    }
}
