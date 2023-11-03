import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingApp {

    private static Map<String, Double> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    checkBalance(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    withdraw(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the banking app. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
}

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        accounts.put(name, initialBalance);
        System.out.println("Account created successfully.");
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        if (accounts.containsKey(name)) {
            double balance = accounts.get(name);
            System.out.println("Your balance is: £" + balance);
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (accounts.containsKey(name)) {
            double currentBalance = accounts.get(name);
            accounts.put(name, currentBalance + amount);
            System.out.println("Deposit successful. Your new balance is: £" + accounts.get(name));
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (accounts.containsKey(name)) {
            double currentBalance = accounts.get(name);
            if (currentBalance >= amount) {
                accounts.put(name, currentBalance - amount);
                System.out.println("Withdrawal successful. Your new balance is: £" + accounts.get(name));
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }
}
