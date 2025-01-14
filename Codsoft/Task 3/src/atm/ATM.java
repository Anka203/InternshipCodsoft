package atm; 
import java.util.Scanner;  

public class ATM {  
    private BankAccount account;  
    private Scanner scanner;  

    public ATM(BankAccount account) {  
        this.account = account;  
        this.scanner = new Scanner(System.in);  
    }  

    public void showMenu() {  
        while (true) {  
            System.out.println("\nATM Menu:");  
            System.out.println("1. Withdraw");  
            System.out.println("2. Deposit");  
            System.out.println("3. Check Balance");  
            System.out.println("4. Exit");  
            System.out.print("Choose an option: ");  

            int choice = scanner.nextInt();  
            performAction(choice);  
            if (choice == 4) break;  
        }  
    }  

    private void performAction(int choice) {  
        switch (choice) {  
            case 1:  
                System.out.print("Enter amount to withdraw: ");  
                double withdrawAmount = scanner.nextDouble();  
                if (account.withdraw(withdrawAmount)) {  
                    System.out.println("Withdrawal successful: $" + withdrawAmount);  
                } else {  
                    System.out.println("Insufficient funds.");  
                }  
                break;  
            case 2:  
                System.out.print("Enter amount to deposit: ");  
                double depositAmount = scanner.nextDouble();  
                account.deposit(depositAmount);  
                System.out.println("Deposit successful: $" + depositAmount);  
                break;  
            case 3:  
                System.out.println("Current balance: $" + account.getBalance());  
                break;  
            case 4:  
                System.out.println("Exiting...");  
                break;  
            default:  
                System.out.println("Invalid option. Please try again.");  
                break;  
        }  
    }  
}