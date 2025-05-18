package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Utility class for handling user input with validation.
 */
public class InputHelper {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for non-empty input.
     * @param prompt The message to display to the user.
     * @return A non-empty string entered by the user.
     */
    public String getNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("This field cannot be empty!");
        }
    }

    /**
     * Prompts the user for a positive double value.
     * @param prompt The message to display to the user.
     * @return A positive double value entered by the user.
     */
    public double getPositiveDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                if (value > 0) return value;
                System.out.println("Value must be positive!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format!");
            }
        }
    }

    /**
     * Prompts the user for a future date.
     * @param prompt The message to display to the user.
     * @return A future date entered by the user.
     */
    public LocalDate getFutureDate(String prompt) {
        while (true) {
            try {
                LocalDate date = LocalDate.parse(getNonEmpty(prompt));
                if (date.isAfter(LocalDate.now())) return date;
                System.out.println("Date must be in the future!");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format!");
            }
        }
    }

    /**
     * Prompts the user for a date.
     * @param prompt The message to display to the user.
     * @return A valid date entered by the user.
     */
    public LocalDate getDate(String prompt) {
        while (true) {
            try {
                return LocalDate.parse(getNonEmpty(prompt));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Use YYYY-MM-DD");
            }
        }
    }

    /**
     * Prompts the user for a date that is after a specified date.
     * @param prompt The message to display to the user.
     * @param afterDate The date that the entered date must be after.
     * @return A date entered by the user that is after the specified date.
     */
    public LocalDate getDateAfter(String prompt, LocalDate afterDate) {
        while (true) {
            LocalDate date = getDate(prompt);
            if (date.isAfter(afterDate)) return date;
            System.out.println("Date must be after " + afterDate);
        }
    }

    /**
     * Prompts the user for a time.
     * @param prompt The message to display to the user.
     * @return A valid time entered by the user.
     */
    public LocalTime getTime(String prompt) {
        while (true) {
            try {
                return LocalTime.parse(getNonEmpty(prompt));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format! Use HH:mm");
            }
        }
    }

    /**
     * Prompts the user for a valid email address.
     * @param prompt The message to display to the user.
     * @return A valid email address entered by the user.
     */
    public String getValidEmail(String prompt) {
        while (true) {
            String email = getNonEmpty(prompt);
            if (Validators.isValidEmail(email)) return email;
            System.out.println("Invalid email format!");
        }
    }

    /**
     * Prompts the user for a string within a specified length range.
     * @param prompt The message to display to the user.
     * @param min The minimum length of the string.
     * @param max The maximum length of the string.
     * @return A valid string entered by the user.
     */
    public String getValidString(String prompt, int min, int max) {
        while (true) {
            String input = getNonEmpty(prompt);
            if (Validators.isValidString(input, min, max)) return input;
            System.out.println("Must be " + min + "-" + max + " characters!");
        }
    }
}