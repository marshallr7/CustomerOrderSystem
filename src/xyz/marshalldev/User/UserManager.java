package xyz.marshalldev.User;

import xyz.marshalldev.StringUtils;

import java.util.*;

public class UserManager {

    private static final Map<Integer, User> users = new HashMap<>();        // User storage - <User ID - User Object>
    private final Scanner scan = new Scanner(System.in);
    int attempts = 1;                                                       // Number of attempts user has taken to log in
    ArrayList<String> securityQuestions = new ArrayList<>() { {             // List of possible security questions
            add("1) In what city were you born?");
            add("2) What is the name of your favorite pet?");
            add("3) What is your mother's maiden name?");
            add("4) What high school did you attend?");
            add("5) What is the name of your first school?");
            add("6) What was the make of your first car?");
        }
    };

    public void addUser(User user) {
        users.putIfAbsent(user.getId(), user);
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public void create() {
        int id = 0;
        String password = null;
        String name;
        String address;
        long creditCardNumber;
        String securityQuestion;
        String answer;

        // ID handling
        id = enterID();
        while (checkID(id) || id == 0) {
            System.out.println("ID value is already taken");
            id = enterID();
        }

        // Password handling
        while (StringUtils.checkPassword(password)) {
            password = enterPassword();
        }

        name = enterName();
        address = enterAddress();
        creditCardNumber = enterCreditCardNumber();

        securityQuestion = selectSecurityQuestion();
        answer = enterSecurityQuestionAnswer();

        User user = new User(id, password, securityQuestion, answer, name, address, creditCardNumber);

        // Confirmation
        System.out.println("\nIs the following information correct? (Y/N)\n " + user.toString());
        char confirmation = scan.next().toLowerCase().charAt(0);

        if (confirmation == 'y') {
            addUser(user);
            System.out.println("Account successfully created.");
            return;
        }
        create();
    }

    public User login() {
        int id;
        String password;
        User user = null;

        id = enterID();
        password = enterPassword();

        // User ID handling
        if (getUser(id) == null || !users.containsKey(id)) {
            System.out.println("ID does not exist in the system.");
            System.exit(0);
        }

        // User password handling
        while (!password.equals(getUser(id).getPassword())) {
            if (attempts >= 3) {
                // Project doesn't describe what it wants us to do if max attempts is exceeded, so assuming this.
                System.out.println("Maximum attempts exceeded. Terminating program.");
                System.exit(0);
            }
            System.out.println("Incorrect password. Attempt " + attempts + "/3");
            attempts++;
            password = enterPassword();
        }

        System.out.println("Login successful" + "\nWelcome to Customer Order System!");
        user = getUser(id);
        return user;
    }

    
    private String selectSecurityQuestion() {
        System.out.println("Select a security question: ");

        for (String securityQuestion : securityQuestions) {
            System.out.println(securityQuestion);
        }

        int selection = scan.nextInt();

        return securityQuestions.get(selection-1);
    }

    private int enterID() {
        System.out.println("Enter an id: ");
        return Integer.parseInt(scan.next());
    }

    private String enterPassword() {
        System.out.println("Enter a password: ");
        return scan.next();
    }

    private String enterName() {
        System.out.println("Enter your name: ");
        return scan.next();
    }

    private String enterAddress() {
        System.out.println("Enter your address: ");
        scan.nextLine(); // Throw away empty input that exists for some unknown reason
        return scan.nextLine();
    }

    private long enterCreditCardNumber() {
        System.out.println("Enter your credit card number: ");
        return scan.nextLong();
    }


    private String enterSecurityQuestionAnswer() {
        System.out.println("Enter the answer: ");
        return scan.next();
    }

    // Check if ID exists in users
    // If it does, return true
    private boolean checkID(int id) {
        return users.containsKey(id);
    }
}
