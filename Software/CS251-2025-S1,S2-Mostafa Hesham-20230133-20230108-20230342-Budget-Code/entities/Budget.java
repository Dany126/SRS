package entities;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents a budget for a specific category with a spending limit
 * and a time period defined by start and end dates.
 * <p>
 * This class is serializable, allowing it to be saved and restored
 * across sessions or transmitted over a network.
 * </p>
 */
public class Budget implements Serializable {

    // Recommended: define a serialVersionUID for Serializable classes
    private static final long serialVersionUID = 1L;

    private final String category;
    private final double limit;
    private final LocalDate startDate;
    private final LocalDate endDate;

    /**
     * Constructs a Budget instance with the specified details.
     *
     * @param category  the category name for this budget (e.g., "Food", "Rent")
     * @param limit     the spending limit for this budget
     * @param startDate the start date of the budget period
     * @param endDate   the end date of the budget period
     */
    public Budget(String category, double limit, LocalDate startDate, LocalDate endDate) {
        this.category = category;
        this.limit = limit;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Gets the category of this budget.
     *
     * @return the budget category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the spending limit of this budget.
     *
     * @return the budget limit
     */
    public double getLimit() {
        return limit;
    }

    /**
     * Gets the start date of the budget period.
     *
     * @return the start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the end date of the budget period.
     *
     * @return the end date
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Returns a string representation of the budget.
     *
     * @return a formatted string showing the category, limit, start, and end dates
     */
    @Override
    public String toString() {
        return String.format("%s: $%.2f (%s to %s)",
                category, limit, startDate, endDate);
    }
}
