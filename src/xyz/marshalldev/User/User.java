package xyz.marshalldev.User;

import xyz.marshalldev.Cart;

public class User {

    private int id;                 // User id number
    private String password;        // User password
    private String question;        // User security question
    private String answer;          // User security question answer
    private String name;            // Users name
    private String address;         // Users address
    private long cardNumber;        // Users credit card number

    private Cart cart;              // Users cart

    public User(int id, String password, String question, String answer, String name, String address, long cardNumber) {
        this.id = id;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.name = name;
        this.address = address;
        this.cardNumber = cardNumber;
        this.cart = new Cart();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "\nid: " + id +
                "\npassword:" + password +
                "\nquestion: " + question +
                "\nanswer: " + answer +
                "\nname: " + name +
                "\naddress: " + address +
                "\ncardNumber: " + cardNumber;
    }
}
