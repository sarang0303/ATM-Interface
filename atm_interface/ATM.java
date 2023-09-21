package atm_interface;

import java.util.Scanner;

public class ATM {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a user and a bank account
        User user = new User("user123", "1234");
        BankAccount bankAccount = new BankAccount();

        // Authenticate the user
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (user.authenticate(userId, pin)) {
            System.out.println("Authentication successful. Welcome to the ATM.");

            boolean exit = false;
            while (!exit) {
                System.out.println("Select an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        bankAccount.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        bankAccount.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter receiver's user ID: ");
                        String receiverId = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        // You would need a way to find the receiver's BankAccount based on their ID
                        // For this simplified example, let's assume the receiver is the same account
                        bankAccount.transfer(bankAccount, transferAmount);
                        break;
                    case 4:
                        System.out.println("Transaction History:");
                        for (Transaction transaction : bankAccount.getTransactionHistory()) {
                            System.out.println(transaction.getTransactionType() + " - " +
                                    transaction.getAmount() + " - " + transaction.getDateTime());
                        }
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting the ATM. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        } else {
            System.out.println("Authentication failed. Exiting...");
        }

        scanner.close();
    }

}
