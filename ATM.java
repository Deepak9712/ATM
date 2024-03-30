import java.util.Scanner;

// BankAccount class representing the user's account
class BankAccount {
  private double balance;

  public BankAccount(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.println("Deposit successful. New balance: $" + balance);
  }

  public boolean withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
      System.out.println("Withdrawal successful. New balance: $" + balance);
      return true;
    } else {
      System.out.println("Insufficient funds. Withdrawal failed.");
      return false;
    }
  }
}

// ATM class representing the user interface and operations
public class ATM {
  private BankAccount account;

  public ATM(BankAccount account) {
    this.account = account;
  }

  public void displayOptions() {
    System.out.println("\nATM Menu:");
    System.out.println("1. Check Balance");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Exit");
  }

  public void executeOption(int option) {
    Scanner scanner = new Scanner(System.in);
    switch (option) {
      case 1:
        System.out.println("Your balance: $" + account.getBalance());
        break;
      case 2:
        System.out.print("Enter deposit amount: $");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        break;
      case 3:
        System.out.print("Enter withdrawal amount: $");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
        break;
      case 4:
        System.out.println("Thank you for using the ATM. Goodbye!");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid option. Please try again.");
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter initial balance: $");
    double initialBalance = scanner.nextDouble();
    BankAccount userAccount = new BankAccount(initialBalance);

    ATM atm = new ATM(userAccount);

    while (true) {
      atm.displayOptions();
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      atm.executeOption(choice);
    }
  }
}
