import managers.*;
import utils.*;

/**
 * Main class for managing financial operations such as budgets, income, expenses, reminders, and user profiles.
 */
public class FinancialManager {
    private final BudgetManager budgetManager = new BudgetManager();
    private final IncomeManager incomeManager = new IncomeManager();
    private final ExpenseManager expenseManager = new ExpenseManager();
    private final ReminderManager reminderManager = new ReminderManager();
    private final UserManager userManager = new UserManager();
    private final InputHelper inputHelper = new InputHelper();

    /**
     * Entry point of the application.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        new FinancialManager().start();
    }

    /**
     * Starts the application and displays the main menu.
     */
    public void start() {
        while (true) {
            System.out.println("\n=== FINANCIAL MANAGER ===");
            System.out.println("1. Login\n2. Register\n3. Exit");
            String choice = inputHelper.getNonEmpty("Choose option: ");

            switch (choice) {
                case "1":
                    if (userManager.login()) showMainMenu();
                    break;
                case "2":
                    userManager.register();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Displays the main menu for managing different financial operations.
     */
    private void showMainMenu() {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Budgets\n2. Income\n3. Expenses\n4. Reminders\n5. Profile\n6. Exit");

            switch (inputHelper.getNonEmpty("Choose option: ")) {
                case "1": handleBudgets(); break;
                case "2": handleIncome(); break;
                case "3": handleExpenses(); break;
                case "4": handleReminders(); break;
                case "5": if (handleProfile()) return; break;
                case "6": return;
                default: System.out.println("Invalid option");
            }
        }
    }

    /**
     * Handles budget-related operations.
     */
    private void handleBudgets() {
        budgetManager.showMenu();
    }

    /**
     * Handles income-related operations.
     */
    private void handleIncome() {
        incomeManager.showMenu();
    }

    /**
     * Handles expense-related operations.
     */
    private void handleExpenses() {
        expenseManager.showMenu();
    }

    /**
     * Handles reminder-related operations.
     */
    private void handleReminders() {
        reminderManager.showMenu();
    }

    /**
     * Handles user profile-related operations.
     * @return true if user logged out, false otherwise
     */
    private boolean handleProfile() {
        userManager.showProfileMenu();
        return userManager.getCurrentUser() == null;
    }
}