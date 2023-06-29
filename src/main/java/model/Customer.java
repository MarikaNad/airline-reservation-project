package model;

import java.util.regex.Pattern;

public class Customer {
    private String name;
    private String surname;
    private String email;


    private static final String emailRegex = "^(.+)@(.+)\\.com$";

    private static final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String name, String surname, String email) {

        if (!validateEmail(email)) {
            throw new IllegalArgumentException("Error, invalid email!");
        }

        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public static boolean validateEmail(String email) {
        return pattern.matcher(email).matches();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
