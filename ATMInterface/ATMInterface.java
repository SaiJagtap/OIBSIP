import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {
    private double balance;
    private ArrayList<String> transactionHistory;

    public ATMInterface() {
        balance = 0.0;
        transactionHistory = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM Interface!");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.println("Choose an option: ");
    }

    public void performOperation(int option) {
        switch (option) {
            case 1:
                displayTransactionHistory();
                break;
            case 2:
                performWithdraw();
                break;
            case 3:
                performDeposit();
                break;
            case 4:
                performTransfer();
                break;
            case 5:
                System.out.println("Thank you for using the ATM Interface. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void performWithdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is " + balance);
            return;
        }

        balance -= amount;
        String transaction = "Withdraw: $" + amount;
        transactionHistory.add(transaction);
        System.out.println("Successfully withdrawn $" + amount + ". Your current balance is " + balance);
    }

    public void performDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        balance += amount;
        String transaction = "Deposit: $" + amount;
        transactionHistory.add(transaction);
        System.out.println("Successfully deposited $" + amount + ". Your current balance is " + balance);
    }

    public void performTransfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is " + balance);
            return;
        }

        System.out.print("Enter the recipient's account number: ");
        int accountNumber = scanner.nextInt();

        // Simulated transfer process
        balance -= amount;
        String transaction = "Transfer: $" + amount + " to Account #" + accountNumber;
        transactionHistory.add(transaction);
        System.out.println("Successfully transferred $" + amount + " to Account #" + accountNumber
                + ". Your current balance is " + balance);
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            int option = scanner.nextInt();
            atm.performOperation(option);
            System.out.println();
        }
    }
}
