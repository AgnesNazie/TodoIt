package se.lexicon.model;

import java.util.Objects;

public class Person {
    //creates fields
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    // New field to store the credentials (AppUser)
    private AppUser credentials;

    //create constructors for fields

    public Person(String firstName, String lastName, String email, AppUser credentials) {

        this.id = ++sequencer;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        this.credentials = credentials;

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
            throw new IllegalArgumentException("Last Name is not allowed to be Null or Empty");
        this.lastName = lastName;
    }
    //getter for email

    public String getEmail() {
        return email;
    }
    // setter for email

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("Email is not allowed to be Null or Empty");
        this.email = email;
    }
    //getter for credentials

    public AppUser getCredentials() {
        return credentials;
    }
    // setter for credentials

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    // Overriding the toString() method to exclude credentials
    @Override
    public String toString() {
        return String.format("Person{id=%d, firstName='%s', lastName='%s', email='%s'}", id, firstName, lastName, email);
    }

    // Overriding equals() and hashCode() to exclude credentials
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
