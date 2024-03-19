import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

public class Main {
    private static Map<Integer, Account> accounts = new HashMap<>();
    private static int accountNumber = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Simple Banking Application");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using Simple Banking Application");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        accountNumber++;
        Account account = new Account(accountNumber, name, initialDeposit);
        accounts.put(accountNumber, account);

        System.out.println("Account created successfully. Your account number is: " + accountNumber);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter your account number: ");
        int accNumber = scanner.nextInt();
        if (accounts.containsKey(accNumber)) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            accounts.get(accNumber).deposit(amount);
        } else {
            System.out.println("Invalid account number.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter your account number: ");
        int accNumber = scanner.nextInt();
        if (accounts.containsKey(accNumber)) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            accounts.get(accNumber).withdraw(amount);
        } else {
            System.out.println("Invalid account number.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter your account number: ");
        int accNumber = scanner.nextInt();
        if (accounts.containsKey(accNumber)) {
            accounts.get(accNumber).displayBalance();
        } else {
            System.out.println("Invalid account number.");
        }
    }
}
