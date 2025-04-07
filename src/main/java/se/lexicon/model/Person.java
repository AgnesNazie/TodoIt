package se.lexicon.model;

import java.util.SplittableRandom;

public class Person {
    //creates fields
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private String email;

    //create constructors for fields

    public Person(String firstName, String lastName, String email) {

        this.id = ++sequencer;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

    }

    // getters  for Id
    public int getId() {
        return id;
    }

    //getters for firstname
    public String getFirstName() {
        return firstName;
    }

    //setters for firstname
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty())
            throw new IllegalArgumentException("First Name it not allowed to be Null or Empty");
        this.firstName = firstName;
    }
    //getter for lastName

    public String getLastName() {
        return lastName;
    }
    // setter for lastName

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty())
            throw  new IllegalArgumentException("Last Name is not allowed to be Null or Empty");
        this.lastName = lastName;
    }
    //getter for email

    public String getEmail() {
        return email;
    }
    // setter for email

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty())
            throw  new IllegalArgumentException("Email is not allowed to be Null or Empty");
        this.email = email;
    }
    // get summary method
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", Name: ").append(firstName).append(" ").append(lastName)
                .append(", Email: ").append(email);
        return sb.toString();
    }
}
