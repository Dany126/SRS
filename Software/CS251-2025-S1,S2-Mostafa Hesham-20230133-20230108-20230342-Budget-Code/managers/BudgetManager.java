package managers;

import entities.Budget;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.InputHelper;
import utils.SerializationHelper;
import utils.Validators;

/**
 * Manages budget records by allowing users to create and view budgets.
 * Provides a menu-driven interface for user interaction.
 */
public class BudgetManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String BUDGETS_FILE = "budgets.ser";
    private List<Budget> budgets;
    private final InputHelper input = new InputHelper();

    public BudgetManager() {
        loadBudgets();
    }

    /**
     * Loads budgets from the serialized file.
     */
    @SuppressWarnings("unchecked")
    private void loadBudgets() {
        Object loaded = SerializationHelper.loadObject(BUDGETS_FILE);
        budgets = (loaded != null) ? (List<Budget>) loaded : new ArrayList<>();
    }

    /**
     * Saves budgets to the serialized file.
     */
    private void saveBudgets() {
        SerializationHelper.saveObject(budgets, BUDGETS_FILE);
    }

    /**
     * Displays the budget management menu and handles user input.
     * Users can create budgets, view existing budgets, or exit the menu.
     */
    public void showMenu() {
        while (true) {
            System.out.println("\n=== BUDGET MANAGEMENT ===");
            System.out.println("1. Create Budget\n2. View Budgets\n3. Back");

            switch (input.getNonEmpty("Choose: ")) {
                case "1":
                    createBudget();
                    break;
                case "2":
                    displayBudgets();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Prompts the user to create a new budget by entering the category, limit, start date, and end date.
     * Validates the budget dates and adds the budget to the list if valid.
     */
    private void createBudget() {
        String category = input.getNonEmpty("Category: ");
        double limit = input.getPositiveDouble("Limit: $");
        LocalDate start = input.getFutureDate("Start Date (YYYY-MM-DD): ");
        LocalDate end = input.getDateAfter("End Date (YYYY-MM-DD): ", start);

        if (!Validators.validateBudget(start, end)) {
            System.out.println("End date must be after start date!");
            return;
        }
        budgets.add(new Budget(category, limit, start, end));
        saveBudgets();
        System.out.println("Budget created!");
    }

    /**
     * Displays all budget records in the list.
     * If no budgets are found, a message is displayed to the user.
     */
    private void displayBudgets() {
        if (budgets.isEmpty()) {
            System.out.println("No budgets found!");
            return;
        }
        budgets.forEach(System.out::println);
    }
}