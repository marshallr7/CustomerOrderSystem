package xyz.marshalldev.User;

public class User {

    private int id;
    private String password;
    private String question;
    private String answer;
    private String name;
    private String address;
    private long cardNumber;


    public User(int id, String password, String question, String answer, String name, String address, long cardNumber) {
        this.id = id;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.name = name;
        this.address = address;
        this.cardNumber = cardNumber;
    }

    public User(int id, String password, String question, String answer) {
        this.id = id;
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    public User(int id, String password) {
        this.id = id;
        this.password = password;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
