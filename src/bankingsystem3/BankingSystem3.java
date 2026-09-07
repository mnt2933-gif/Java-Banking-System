package bankingsystem3;

import java.util.Scanner;

public class BankingSystem3 {

    static String name;        //Stores the account holder`s name .       يخزن اسم صاحب الحساب 
    static double balance;    //stores the carrent balance .  يخزن الرصيد الحالي 
    static boolean accountCreated = false; //Tracks if account exists .  يتتبع ما اذا كان الحساب موجود 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    viewBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using Simple Banking System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
            //Displays the main menu optins to the user     اظهار الواجهه الرئيسيه للمستخدم 
    public static void printMenu() {
        System.out.println("Simple Banking System");
        System.out.println("1. Create Account ");
        System.out.println("2. Deposit ");
        System.out.println("3. withdraw ");
        System.out.println("4. View Balance");
        System.out.println("5. Exit");
        System.out.print("Enter your choice:");
    }
             //Creates a new bank account for the user  انشاء حساب مصرفي جديد
    public static void createAccount() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name:");
        name = in.nextLine();
        accountCreated = true;
        System.out.println("Account created successfully.");
        System.out.println("Welcome," + name + "!");
    }
            //Deposit mony into the account after validation ايداع او ادخال مال الى الحساب     
    public static void deposit() {
        if (!accountCreated) {
            System.out.println("Error: Please create an account first.");
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter deposit amount:");
            double amount = in.nextDouble();
            if (amount <= 0) {
                System.out.println("Error:Invalid amount.");
            } else {
                System.out.println("Deposit successful.");
                balance += amount;
            }
        }
    }
           //Withdraw  mony into the account after validatioسحب مال الى الحساب         
    public static void withdraw() {
        if (!accountCreated) {
            System.out.println("Error: Please create an account first.");
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter withdraw amount:");
            double amount = in.nextDouble();
            if (amount < 0) {
                System.out.println("Error:Invalid amount.");
            } else if (amount > balance) {
                System.out.println("Error: Insufficient balance.");
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful .");
            }
        }
    }
         ///Displays the current account balance               يعرض قيمه الرصيد
    public static void viewBalance() {
        if (accountCreated == true) {
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Error: Please create an account first.");
        }
    }
}
