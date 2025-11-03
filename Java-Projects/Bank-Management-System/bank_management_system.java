import java.util.Scanner;
class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;
    private String accountType;
    private StringBuilder transactionHistory;

    public BankAccount(String name, int accNum, double bal, String type) {
        this.accountHolderName = name;
        this.accountNumber = accNum;
        this.balance = bal;
        this.accountType = type;
        this.transactionHistory = new StringBuilder("No transactions yet");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            if (transactionHistory.toString().equals("No transactions yet")) {
                transactionHistory = new StringBuilder("Deposited: " + amount);
            } else {
                transactionHistory.append("\nDeposited: ").append(amount);
            }
            System.out.println("Deposited " + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            if (transactionHistory.toString().equals("No transactions yet")) {
                transactionHistory = new StringBuilder("Withdrew: " + amount);
            } else {
                transactionHistory.append("\nWithdrew: ").append(amount);
            }
            System.out.println("Withdrew " + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void checkBalance() {
        System.out.println("Account Balance: " + balance);
    }

    public void calculateInterest() {
        double interestRate = 0.0;
        if (accountType.equalsIgnoreCase("Savings")) {
            interestRate = 0.04;
        } else if (accountType.equalsIgnoreCase("Current")) {
            interestRate = 0.02;
        }

        double interest = balance * interestRate;
        balance += interest;
        if (transactionHistory.toString().equals("No transactions yet")) {
            transactionHistory = new StringBuilder("Interest applied: " + interest);
        } else {
            transactionHistory.append("\nInterest applied: ").append(interest);
        }
        System.out.println("Interest applied: " + interest + " successfully.");
    }

    public void display() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        checkBalance();
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory);
    }
}

public class bank_management_system {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        int accountNum = scanner.nextInt();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        System.out.print("Enter Account Type (Savings/Current): ");
        String accountType = scanner.next();

        BankAccount account = new BankAccount(name, accountNum, initialBalance, accountType);

        int choice;
        double amount;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Account Information");
            System.out.println("2. Display Transaction History");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Calculate Interest");
            System.out.println("6. Check Balance");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.display();
                    break;
                case 2:
                    account.displayTransactionHistory();
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;
                case 4:
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    break;
                case 5:
                    account.calculateInterest();
                    break;
                case 6:
                    account.checkBalance();
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
