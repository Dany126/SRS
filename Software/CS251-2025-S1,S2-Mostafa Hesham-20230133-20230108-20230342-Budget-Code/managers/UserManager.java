package managers;

import entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import utils.InputHelper;
import utils.SerializationHelper;

/**
 * Manages user-related operations such as login, registration, and profile
 * management.
 */
public class UserManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String USERS_FILE = "users.ser";
    private List<User> users;
    private final InputHelper input = new InputHelper();
    private User currentUser; // Track logged-in user

    public UserManager() {
        loadUsers();
    }

    /**
     * Loads users from the serialized file.
     */
    @SuppressWarnings("unchecked")
    private void loadUsers() {
        Object loaded = SerializationHelper.loadObject(USERS_FILE);
        users = (loaded != null) ? (List<User>) loaded : new ArrayList<>();
    }

    /**
     * Saves users to the serialized file.
     */
    private void saveUsers() {
        SerializationHelper.saveObject(users, USERS_FILE);
    }

    /**
     * Displays the profile management menu.
     */
    public void showProfileMenu() {
        while (true) {
            System.out.println("\n=== PROFILE MANAGEMENT ===");
            System.out.println("1. Change Password\n2. Logout\n3. Back");

            switch (input.getNonEmpty("Choose: ")) {
                case "1":
                    changePassword();
                    break;
                case "2":
                    if (logout())
                        return;
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Allows the user to change their password.
     */
    private void changePassword() {
        if (currentUser == null) {
            System.out.println("No user logged in!");
            return;
        }

        String oldPassword = input.getNonEmpty("Enter current password: ");
        if (!currentUser.validatePassword(oldPassword)) {
            System.out.println("Incorrect current password!");
            return;
        }

        String newPassword = input.getNonEmpty("Enter new password: ");
        currentUser.setPassword(newPassword);
        saveUsers();
        System.out.println("Password changed successfully!");
    }

    /**
     * Logs out the current user.
     * 
     * @return true to indicate return to main menu
     */
    private boolean logout() {
        currentUser = null;
        System.out.println("Logged out successfully!");
        return true;
    }

    /**
     * Logs in a user by validating their credentials.
     * 
     * @return true if login is successful, false otherwise.
     */
    public boolean login() {
        String username = input.getNonEmpty("Username: ");
        String password = input.getNonEmpty("Password: ");

        currentUser = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.validatePassword(password))
                .findFirst()
                .orElse(null);

        if (currentUser != null) {
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid credentials!");
        return false;
    }

    /**
     * Registers a new user.
     */
    public void register() {
        String username = input.getNonEmpty("Username: ");
        String password = input.getNonEmpty("Password: ");
        String email = input.getValidEmail("Email: ");

        users.add(new User(username, password, email));
        saveUsers();
        System.out.println("Registration successful!");
    }

    /**
     * Gets the currently logged-in user.
     * 
     * @return the current user, or null if no user is logged in
     */
    public User getCurrentUser() {
        return currentUser;
    }
}