package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Utility class for validating various inputs and conditions.
 */
public class Validators {

    /**
     * Validates if the given email address is in a valid format.
     * @param email The email address to validate.
     * @return true if the email contains "@" and ".", false otherwise.
     */
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    /**
     * Validates if the given reminder date and time is in the future.
     * @param dateTime The date and time to validate.
     * @return true if the date and time is after the current date and time, false otherwise.
     */
    public static boolean validateReminder(LocalDateTime dateTime) {
        return dateTime.isAfter(LocalDateTime.now());
    }

    /**
     * Validates if the given string is within the specified length range.
     * @param input The string to validate.
     * @param min The minimum length of the string.
     * @param max The maximum length of the string.
     * @return true if the string length is between min and max (inclusive), false otherwise.
     */
    public static boolean isValidString(String input, int min, int max) {
        return input.length() >= min && input.length() <= max;
    }

    /**
     * Validates if the budget's end date is after the start date.
     * @param start The start date of the budget.
     * @param end The end date of the budget.
     * @return true if the end date is after the start date, false otherwise.
     */
    public static boolean validateBudget(LocalDate start, LocalDate end) {
        return end.isAfter(start);
    }

    /**
     * Validates if the transaction amount is positive.
     * @param amount The transaction amount to validate.
     * @return true if the amount is greater than 0, false otherwise.
     */
    public static boolean validateTransaction(double amount) {
        return amount > 0;
    }
}