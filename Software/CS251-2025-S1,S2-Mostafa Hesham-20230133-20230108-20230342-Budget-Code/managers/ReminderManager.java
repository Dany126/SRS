package managers;

import entities.Reminder;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import utils.InputHelper;
import utils.SerializationHelper;

/**
 * Manages reminders by allowing users to create and view reminders.
 * Provides a menu-driven interface for user interaction.
 */
public class ReminderManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String REMINDERS_FILE = "reminders.ser";
    private List<Reminder> reminders;
    private final InputHelper input = new InputHelper();

    public ReminderManager() {
        loadReminders();
    }

    /**
     * Loads reminders from the serialized file.
     */
    @SuppressWarnings("unchecked")
    private void loadReminders() {
        Object loaded = SerializationHelper.loadObject(REMINDERS_FILE);
        reminders = (loaded != null) ? (List<Reminder>) loaded : new ArrayList<>();
    }

    /**
     * Saves reminders to the serialized file.
     */
    private void saveReminders() {
        SerializationHelper.saveObject(reminders, REMINDERS_FILE);
    }

    /**
     * Displays the reminder management menu and handles user input.
     * Users can create reminders, view existing reminders, or exit the menu.
     */
    public void showMenu() {
        while (true) {
            System.out.println("\n=== REMINDER MANAGEMENT ===");
            System.out.println("1. Create Reminder\n2. View Reminders\n3. Back");

            switch (input.getNonEmpty("Choose: ")) {
                case "1":
                    createReminder();
                    break;
                case "2":
                    displayReminders();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Prompts the user to create a new reminder by entering a title, date, and time.
     * The reminder is then added to the list of reminders.
     */
    public void createReminder() {
        String title = input.getValidString("Title: ", 3, 50);
        LocalDate date = input.getFutureDate("Date (YYYY-MM-DD): ");
        LocalTime time = input.getTime("Time (HH:mm): ");
        reminders.add(new Reminder(title, date, time));
        saveReminders();
        System.out.println("Reminder set!");
    }

    /**
     * Displays all reminders in the list.
     * If no reminders are found, a message is displayed to the user.
     */
    private void displayReminders() {
        if (reminders.isEmpty()) {
            System.out.println("No reminders found!");
            return;
        }
        reminders.forEach(System.out::println);
    }
}