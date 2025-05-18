package entities;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents an expense with an amount, category, payment method, and date.
 * <p>
 * This class implements Serializable, allowing expense objects to be
 * saved to disk or transmitted over a network.
 * </p>
 */
public class Expense implements Serializable {

    // Recommended: define a serialVersionUID for Serializable classes
    private static final long serialVersionUID = 1L;

    private final double amount;
    private final String category;
    private final String paymentMethod;
    private final LocalDate date;

    /**
     * Constructs an Expense instance with the specified details.
     *
     * @param amount   the amount of the expense
     * @param category the category of the expense (e.g., "Food", "Transport")
     * @param method   the payment method used (e.g., "Cash", "Credit Card")
     * @param date     the date of the expense
     */
    public Expense(double amount, String category, String method, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.paymentMethod = method;
        this.date = date;
    }

    /**
     * Gets the amount of this expense.
     *
     * @return the expense amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the category of this expense.
     *
     * @return the expense category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the payment method of this expense.
     *
     * @return the payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Gets the date of this expense.
     *
     * @return the date of the expense
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns a string representation of the expense.
     *
     * @return a formatted string showing the amount, category, payment method, and
     *         date
     */
    @Override
    public String toString() {
        return String.format("[Expense] $%.2f on %s (%s) - %s",
                amount, category, paymentMethod, date);
    }
}
