import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount 
{
       private double balance;

       public BankAccount(double initialBalance) 
         {
           this.balance = initialBalance;
         }

       // Method to deposit money
       public void deposit(double amount) 
         {
           if (amount > 0) 
             {
               balance += amount;
               System.out.println("Deposited: $" + amount);
             } 
           else 
             {
               System.out.println("Invalid deposit amount. Must be greater than zero.");
             }
         }

       // Method to withdraw money
       public boolean withdraw(double amount) 
         {
           if (amount > 0 && amount <= balance) 
             {
               balance = balance-amount;
               System.out.println("Withdrew: $" + amount);
               return true;
             }
           else 
             {
               if (amount <= 0) 
                 {
                   System.out.println("Invalid withdrawal amount. Must be greater than zero.");
                 } 
               else
                 {
                   System.out.println("Insufficient balance.");
                 }
               return false;
             }
         }

       // Method to check the account balance
       public double getBalance() 
        {
          return balance;
        }
}

// Class to represent the ATM interface
class ATM 
{
     private BankAccount account;
     private Scanner scan;

     public ATM(BankAccount account) 
      {
        this.account = account;
        this.scan = new Scanner(System.in);
      }

    // Method to display the ATM menu
     private void displayMenu() 
      {
          System.out.println("\nATM Menu:");
          System.out.println("1. Check Balance");
          System.out.println("2. Deposit Money");
          System.out.println("3. Withdraw Money");
          System.out.println("4. Exit ATM Interface");
          System.out.println("Choose an option");
      }

    // Method to handle ATM operations
     public void run() 
      {
         int option;
         do {
             displayMenu();
             option = scan.nextInt();

             switch (option) 
               {
                 case 1:
                     checkBalance();
                     break;
                 case 2:
                     deposit();
                     break;
                 case 3:
                     withdraw();
                     break;
                 case 4:
                     System.out.println("Exiting. Thank you for using the ATM.");
                     break;
                 default:
                     System.out.println("Invalid option. Please try again(Choose a number between 1 and 4)");
               }
            } while (option != 4);
       }   

      // Method to check the account balance
      private void checkBalance()
       {
         System.out.println("Current balance: $" + account.getBalance());
       }

      // Method to deposit money
      private void deposit()
       {
         System.out.print("Enter amount to deposit: ");
         double amount = scan.nextDouble();
         account.deposit(amount);
       }

      // Method to withdraw money
      private void withdraw() 
       {
         System.out.print("Enter amount to withdraw: ");
         double amount = scan.nextDouble();
         account.withdraw(amount);
       }
}

// Main class to run the ATM program
public class ATMinterface
{
    public static void main(String arg[])
    {
        BankAccount account = new BankAccount(2000.00); //Setting Initial balance as 2000$
        ATM atm = new ATM(account);
        atm.run();
    }
}
