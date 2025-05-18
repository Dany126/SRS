package entities;

import java.io.Serializable;

/**
 * Represents a user with a username, password, and email.
 * <p>
 * This class implements Serializable, allowing user objects
 * to be saved to disk or transmitted over a network.
 * </p>
 */
public class User implements Serializable {

    // define a serialVersionUID for Serializable classes
    private static final long serialVersionUID = 1L;

    private final String username;
    private String password;
    private final String email;

    /**
     * Constructs a User instance with the specified details.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param email    the email address of the user
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Gets the username of this user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the email address of this user.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Validates whether the provided input matches the user's password.
     *
     * @param input the password input to check
     * @return true if the input matches the stored password; false otherwise
     */
    public boolean validatePassword(String input) {
        return password.equals(input);
    }

    /**
     * Sets a new password for the user.
     *
     * @param newPassword the new password to set
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
