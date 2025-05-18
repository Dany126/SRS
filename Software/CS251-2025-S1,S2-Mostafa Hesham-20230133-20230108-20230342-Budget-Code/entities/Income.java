package entities;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents an income entry with an amount, source, and date.
 * <p>
 * This class implements Serializable, allowing income objects to be
 * saved to disk or transmitted over a network.
 * </p>
 */
public class Income implements Serializable {

    // Recommended: define a serialVersionUID for Serializable classes
    private static final long serialVersionUID = 1L;

    private final double amount;
    private final String source;
    private final LocalDate date;

    /**
     * Constructs an Income instance with the specified details.
     *
     * @param amount the amount of the income
     * @param source the source of the income (e.g., "Salary", "Freelance")
     * @param date   the date the income was received
     */
    public Income(double amount, String source, LocalDate date) {
        this.amount = amount;
        this.source = source;
        this.date = date;
    }

    /**
     * Gets the amount of this income.
     *
     * @return the income amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the source of this income.
     *
     * @return the income source
     */
    public String getSource() {
        return source;
    }

    /**
     * Gets the date the income was received.
     *
     * @return the income date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns a string representation of the income.
     *
     * @return a formatted string showing the amount, source, and date
     */
    @Override
    public String toString() {
        return String.format("[Income] $%.2f from %s on %s", amount, source, date);
    }
}
