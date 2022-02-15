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
}
