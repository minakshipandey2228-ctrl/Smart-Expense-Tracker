import java.io.*;
import java.util.*;

class Expense {
    private String category;
    private double amount;
    private String description;

    public Expense(String category, double amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Category: " + category + " | Amount: ₹" + amount + " | Description: " + description;
    }
}

public class SmartExpenseTracker {
    private static final String FILE_NAME = "expenses.txt";
    private static List<Expense> expenseList = new ArrayList<>();
    private static double budgetLimit = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadExpensesFromFile();

        System.out.print("Enter your total monthly budget limit (in ₹): ");
        budgetLimit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        while (true) {
            System.out.println("\n========== SMART EXPENSE TRACKER ==========");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Spending & Budget Alert");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    checkBudget();
                    break;
                case 4:
                    saveExpensesToFile();
                    System.out.println("Expenses saved successfully. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter Category (e.g., Food, Travel, Books): ");
        String category = scanner.nextLine();
        System.out.print("Enter Amount (in ₹): ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter Short Description: ");
        String description = scanner.nextLine();

        Expense expense = new Expense(category, amount, description);
        expenseList.add(expense);
        System.out.println("✓ Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        System.out.println("\n--- Your
