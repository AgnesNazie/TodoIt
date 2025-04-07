package se.lexicon.model;

import java.util.Objects;

public class AppUser {

    private String username;
    private String password;
    private AppRole role;

    //constructors

    public AppUser(String username, String password, AppRole role) {

        setUserName(username);
        setPassword(password);
        setRole(role);
    }
    //getter for username

    public String getUsername() {
        return username;
    }
    //setter for userName

    public void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty())
            throw new IllegalArgumentException("Username cannot be null or empty");
        this.username = userName;
    }
    //getter for password

    public String getPassword() {
        return password;
    }
    //setter for password

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty())
            throw new IllegalArgumentException("Password cannot be null or empty");
        this.password = password;
    }
    //getter for role

    public AppRole getRole() {
        return role;
    }
    //setter for role

    public void setRole(AppRole role) {
        if (role == null)
            throw new IllegalArgumentException("Role cannot be null");
        this.role = role;
    }

    // Overriding equals method to compare AppUser objects based on username and role
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AppUser appUser = (AppUser) obj;
        return Objects.equals(username, appUser.username) && role == appUser.role;
    }

    // Overriding hashCode method to generate hash based on username and role
    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    // Overriding toString method to represent AppUser object as a string (excluding password)
    @Override
    public String toString() {
        return String.format("AppUser{username='%s', role=%s}", username, role);
    }
}

}
