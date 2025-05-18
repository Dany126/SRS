package managers;

import entities.Income;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utils.InputHelper;
import utils.SerializationHelper;

/**
 * Manages income records by allowing users to add and view income entries.
 * Provides a menu-driven interface for user interaction.
 */
public class IncomeManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String INCOMES_FILE = "incomes.ser";
    private List<Income> incomes;
    private final InputHelper input = new InputHelper();

    public IncomeManager() {
        loadIncomes();
    }

    /**
     * Loads incomes from the serialized file.
     */
    @SuppressWarnings("unchecked")
    private void loadIncomes() {
        Object loaded = SerializationHelper.loadObject(INCOMES_FILE);
        incomes = (loaded != null) ? (List<Income>) loaded : new ArrayList<>();
    }

    /**
     * Saves incomes to the serialized file.
     */
    private void saveIncomes() {
        SerializationHelper.saveObject(incomes, INCOMES_FILE);
    }

    /**
     * Displays the income management menu and handles user input.
     * Users can add income, view income history, or exit the menu.
     */
    public void showMenu() {
        while (true) {
            System.out.println("\n=== INCOME MANAGEMENT ===");
            System.out.println("1. Add Income\n2. View History\n3. Back");

            switch (input.getNonEmpty("Choose: ")) {
                case "1":
                    addIncome();
                    break;
                case "2":
                    displayIncome();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Prompts the user to add a new income record by entering the amount, source, and date.
     * The income record is then added to the list of incomes.
     */
    public void addIncome() {
        double amount = input.getPositiveDouble("Amount: $");
        String source = input.getNonEmpty("Source: ");
        LocalDate date = input.getDate("Date (YYYY-MM-DD): ");
        incomes.add(new Income(amount, source, date));
        saveIncomes();
        System.out.println("Income recorded!");
    }

    /**
     * Displays all income records in the list.
     * If no income records are found, a message is displayed to the user.
     */
    private void displayIncome() {
        if (incomes.isEmpty()) {
            System.out.println("No income records found!");
            return;
        }
        incomes.forEach(System.out::println);
    }
}