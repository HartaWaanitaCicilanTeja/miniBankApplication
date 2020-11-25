package com.miniBankApplicationArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("XYZ");

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: (7 to show instructions)");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        addNewBranch();
                        break;
                    case 2:
                        bank.printListBranch();
                        break;
                    case 3:
                        addNewCustomer();
                        break;
                    case 4:
                       printcustNamebyBranch();
                        break;
                    case 5:
                        // addCustomerTransaction();
                        break;
                    case 6:
                        // printCustomerTransaction();
                        break;
                    case 7:
                        printInstructions();
                        break;
                }
            } else {
                System.out.println("Please enter correct choice");
                scanner.nextLine();
            }

        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - to quit the banking application ");
        System.out.println("\t 1 - To add a new branch.");
        System.out.println("\t 2 - To print list branch.");
        System.out.println("\t 3 - To add a customer to a branch.");
        System.out.println("\t 4 - To print list of customers of a branch.");
        System.out.println("\t 5 - To add a transaction for a customer.");
        System.out.println("\t 6 - To print list of transactions for a customer.");
        System.out.println("\t 7 - To print choice options.");
    }

    public static void addNewBranch() {
        System.out.println(" Please enter your Branch Name");
        bank.addNewBranch(scanner.nextLine());
    }

    public static void addNewCustomer() {
        System.out.print(" Please enter  the branch name\n and the customer name \n and your first deposit ");
        bank.addNewCustomer(scanner.nextLine(), scanner.nextLine(), scanner.nextDouble());
//            mpc.addContactName(sc.nextLine(), sc.nextLong());
    }

    public static void searchForItem() {
        System.out.print(" enter your Branchname : ");
        String searchItem = scanner.nextLine();

        if (bank.onFile(searchItem)) {

            System.out.println("Found " + searchItem + " in your branch List" );
        } else {
            System.out.println(searchItem + " is not in your system list ");
        }
    }
public static void printcustNamebyBranch(){
    System.out.print(" enter your Branchname : ");
    bank.printListCustomer(scanner.nextLine());
}


    }




