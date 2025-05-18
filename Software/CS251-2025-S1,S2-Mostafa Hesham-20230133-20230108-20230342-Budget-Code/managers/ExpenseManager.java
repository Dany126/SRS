package managers;

import entities.Expense;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.InputHelper;
import utils.SerializationHelper;

/**
 * Manages expense records by allowing users to add and view expense entries.
 * Provides a menu-driven interface for user interaction.
 */
public class ExpenseManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String EXPENSES_FILE = "expenses.ser";
    private List<Expense> expenses;
    private final InputHelper input = new InputHelper();

    public ExpenseManager() {
        loadExpenses();
    }

    /**
     * Loads expenses from the serialized file.
     */
    @SuppressWarnings("unchecked")
    private void loadExpenses() {
        Object loaded = SerializationHelper.loadObject(EXPENSES_FILE);
        expenses = (loaded != null) ? (List<Expense>) loaded : new ArrayList<>();
    }

    /**
     * Saves expenses to the serialized file.
     */
    private void saveExpenses() {
        SerializationHelper.saveObject(expenses, EXPENSES_FILE);
    }

    /**
     * Displays the expense management menu and handles user input.
     * Users can add expenses, view expense history, or exit the menu.
     */
    public void showMenu() {
        while (true) {
            System.out.println("\n=== EXPENSE MANAGEMENT ===");
            System.out.println("1. Add Expense\n2. View History\n3. Back");

            switch (input.getNonEmpty("Choose: ")) {
                case "1":
                    addExpense();
                    break;
                case "2":
                    displayExpenses();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Prompts the user to add a new expense record by entering the amount, category, payment method, and date.
     * The expense record is then added to the list of expenses.
     */
    public void addExpense() {
        double amount = input.getPositiveDouble("Amount: $");
        String category = input.getNonEmpty("Category: ");
        String method = input.getNonEmpty("Payment Method: ");
        LocalDate date = input.getDate("Date (YYYY-MM-DD): ");
        expenses.add(new Expense(amount, category, method, date));
        saveExpenses();
        System.out.println("Expense recorded!");
    }

    /**
     * Displays all expense records in the list.
     * If no expense records are found, a message is displayed to the user.
     */
    private void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }
        expenses.forEach(System.out::println);
    }
}