package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a reminder with a title, date, and time.
 * <p>
 * This class implements Serializable, allowing reminder objects
 * to be saved to disk or transmitted over a network.
 * </p>
 */
public class Reminder implements Serializable {

    // Recommended: define a serialVersionUID for Serializable classes
    private static final long serialVersionUID = 1L;

    private final String title;
    private final LocalDate date;
    private final LocalTime time;

    /**
     * Constructs a Reminder instance with the specified details.
     *
     * @param title the title or description of the reminder
     * @param date  the date of the reminder
     * @param time  the time of the reminder
     */
    public Reminder(String title, LocalDate date, LocalTime time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    /**
     * Gets the title or description of this reminder.
     *
     * @return the reminder title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the date of this reminder.
     *
     * @return the reminder date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the time of this reminder.
     *
     * @return the reminder time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Returns a string representation of the reminder.
     *
     * @return a formatted string showing the title, date, and time
     */
    @Override
    public String toString() {
        return String.format("[Reminder] %s at %s %s", title, date, time);
    }
}
