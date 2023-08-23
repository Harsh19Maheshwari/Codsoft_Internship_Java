package ATM_INTERFACE;

import java.util.Scanner;

interface ATMinterface {

    void withdraw(double amount);

    void deposit(double amount);

    void checkBalance();

}

class UserAccount implements ATMinterface {

    private double balance;

    UserAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Rs. " + amount + " withdrawn successfully");
            System.out.print("\n");

        } else {
            System.out.println("Withdrawn Failure!! Unable to withdraw due to Insufficient Balance.");
            System.out.print("\n");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount; //balance = balance + amount
        System.out.println("Rs. " + amount + " deposited successfully.");
        System.out.print("\n");
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + balance);
        System.out.print("\n");
    }
}

public class ATM {

    public static void main(String[] args) {

        UserAccount obj = new UserAccount(10000);
        Scanner sc = new Scanner(System.in);

        int option;
        double amount;

        System.out.println("Welcome to the ATM Machine");
        System.out.print("\n");
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit the Money");
            System.out.println("3. Withdraw the Money");
            System.out.println("4. Exit");

            System.out.print("\n");
            System.out.print("Please Select an Option from the above : ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    obj.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    amount = sc.nextDouble();
                    obj.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    amount = sc.nextDouble();
                    obj.withdraw(amount);
                    break;
                case 4:
                    System.out.print("\n");
                    System.out.println("Successfully Exit.");
                    System.out.println("Thank you for using the Services.");
                    System.out.println("Please Visit Again!!");
                    break;
                default:
                    System.out.println("Invalid Option!! Please Try Again with the appropriate options.");
                    System.out.print("\n");
            }
        } while (option != 4);
        sc.close();
    }

}
