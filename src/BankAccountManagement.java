/*Bank Account Management with Exception Handling
Bank Account Creation:
Users can create new bank accounts with an initial balance.
Deposit Funds:
Users can deposit funds into their bank accounts.
Withdraw Funds:
Users can withdraw funds from their bank accounts, provided they have sufficient balance.
Transfer Funds:
Users can transfer funds from their account to another account, provided they have sufficient balance.
Error Handling:
Handle various exceptions that may occur during deposit, withdrawal, or transfer operations.
Include custom exception classes for specific scenarios (e.g...InsufficientFundsException)
*/
import java.util.Scanner;

public class BankAccountManagement {

    private static double totalBal = 0.0;

    static Scanner sc = new Scanner(System.in);

    private static void addFunds(double amount) {

        totalBal = totalBal + amount;

    }

    private static void withdrawFunds(double amountW) {

        if(amountW >totalBal){

            throw new InSufficientFundsException("Withdrawal amount is greater than total balance");

        }else if (totalBal-amountW <3000) {

            throw new MinimumBalanceException("Minimum balance should be greater than 3000 you cannot withdraw this amount please enter another amount");
        }else{
            totalBal=totalBal-amountW;
        }
    }

    private static void transferFunds() {

        System.out.println("Enter Bank Name");
        String bankName=sc.next();

        System.out.println("Enter Account No to transfer money");
        int accountNo=sc.nextInt();

        System.out.println("Enter amount to be transferred");
        double amount=sc.nextDouble();

        if(amount > totalBal){

            throw new InSufficientFundsException("Amount to be transfer is greater than total balance");
        }else{

            totalBal=totalBal-amount;
            System.out.println("Amount transferred successfully!");
        }
    }

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your choice");
        System.out.println();
        System.out.println("1. Create New Bank Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Check Account Balance");
        System.out.println("6. Exit");

        int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    RegistrationForm.main(args);
                    System.out.println("To create account you must have minimum 3000rs balance");

                    System.out.println("Enter your choice");
                    System.out.println("1. Add funds");
                    System.out.println("2. Exit");
                    int choice2 = sc.nextInt();
                    switch (choice2) {

                        case 1:
                            System.out.println("Enter amount to be add");
                            double amount = sc.nextDouble();
                            if(amount<3000){
                                throw new MinimumBalanceException("Minimum amount in account should be 3000");
                            }else {
                                addFunds(amount);
                            }
                            break;
                        case 2:
                            exit = true;
                            break;

                        default:
                            System.out.println("Enter valid choice");
                            break;
                    }
                    System.out.println("Account Created Successfully!");
                    break;

                case 2:
                    System.out.println("Enter amount to be add");
                    double amount = sc.nextDouble();
                    addFunds(amount);
                    break;

                case 3:
                    System.out.println("Enter amount to be withdraw");
                    double amountW = sc.nextDouble();
                    withdrawFunds(amountW);
                    break;

                case 4:
                    transferFunds();
                    break;

                case 5:
                    System.out.println("TotalBalace: "+totalBal);
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
    }
}
