package application;

import model.entities.Account;
import model.exceptions.BalanceException;
import model.exceptions.LimitException;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data:");
        System.out.print("Account number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Account holder: ");
        String name = sc.nextLine();
        System.out.print("Initial balance: $");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: $");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, name, balance, withdrawLimit);
        System.out.println();

        while (true) {
            try {
                System.out.print("Enter amount for withdraw: $");
                double amount = sc.nextDouble();
                account.withdraw(amount);
                System.out.println("New balance: $" + String.format("%.2f", account.getBalance()));
                break;
            } catch (BalanceException b) {
                System.out.println("Withdraw error: " + b.getMessage());
            } catch (LimitException l) {
                System.out.println("Withdraw error: " + l.getMessage());
            }
        }
    }
}
