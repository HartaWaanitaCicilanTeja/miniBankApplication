package com.testBank;
import java.util.Scanner;
public class MainTest {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("XYZ");

    public static void main(String[] args){
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice: (7 to show instructions)");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        addBranch();
                        break;
                    case 2:
                        bank.printBranchList();
                        break;
                    case 3:
                        addCustomer();
                        break;
                    case 4:
                        printBranchCustomers();
                        break;
                    case 5:
                        addCustomerTransaction();
                        break;
                    case 6:
                        printCustomerTransaction();
                        break;
                    case 7:
                        printInstructions();
                        break;
                }
            }else{
                System.out.println("Please enter correct choice");
                scanner.nextLine();
            }

        }

    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - to quit the banking application " );
        System.out.println("\t 1 - To add a new branch.");
        System.out.println("\t 2 - To print list branch.");
        System.out.println("\t 3 - To add a customer to a branch.");
        System.out.println("\t 4 - To print list of customers of a branch.");
        System.out.println("\t 5 - To add a transaction for a customer.");
        System.out.println("\t 6 - To print list of transactions for a customer.");
        System.out.println("\t 7 - To print choice options.");
    }

    public static void addBranch(){
        System.out.println("Please enter the Branch name: ");
        String name = scanner.nextLine();
        Branch newBranch = Branch.addNewBranch(name);
        if(bank.addNewBranch(newBranch)){
            System.out.println("New branch added " + name);
        }else{
            System.out.println("Cannot add, " +  name +" already on file");
        };
    }

    public static void addCustomer(){
        System.out.println("Please enter the Branch name: ");
        String branchName = scanner.nextLine();
        Branch existingBranch = bank.queryBranch(branchName);
        if(existingBranch == null){
            System.out.println("Branch " + branchName + " does not exist");
            return;
        }else{
            System.out.println("Please enter the customer name: ");
            String customerName = scanner.nextLine();
            Customer existingCustomer = existingBranch.queryCustomer(customerName);
            if(existingCustomer == null){
                System.out.println("Please enter the initial deposit amount: ");
                double amount=0;
                boolean quit=false;
                while (!quit){
                    if (scanner.hasNextDouble()){
                        amount = scanner.nextDouble();
                        quit=true;
                    }else{
                        System.out.println("Enter valid deposit amount");
                        scanner.nextLine();
                    }
                }
                Customer customer = Customer.addNewCustomer(customerName,amount);
                if(existingBranch.addNewCustomer(customer)){
                    System.out.println("Customer "+ customerName + " added for the branch " + branchName);
                }
            }else{
                System.out.println("Customer " + customerName +  " is on file");
                return;
            }

        }
    }

    public static void addCustomerTransaction(){
        System.out.println("Please enter the Branch name: ");
        String branchName = scanner.nextLine();
        Branch existingBranch = bank.queryBranch(branchName);
        if(existingBranch == null){
            System.out.println("Branch " + branchName + " does not exist");
            return;
        }else{
            System.out.println("Please enter the customer name: ");
            String customerName = scanner.nextLine();
            Customer existingCustomer = existingBranch.queryCustomer(customerName);
            if(existingCustomer == null){
                System.out.println("Customer " + customerName +  " is not on file");
                return;
            }else{
                System.out.println("Please enter the deposit amount: ");
                double amount=0;
                boolean quit=false;
                while (!quit){
                    if (scanner.hasNextDouble()){
                        amount = scanner.nextDouble();
                        quit=true;
                    }else{
                        System.out.println("Enter valid deposit amount");
                        scanner.nextLine();
                    }
                }
                if (existingCustomer.addTransaction(amount)){
                    System.out.println("Transaction added successully");
                }else{
                    System.out.println("Error completing the transaction");
                    return;
                }
            }
        }
    }

    public static void printBranchCustomers(){
        System.out.println("Please enter the Branch name: ");
        String branchName = scanner.nextLine();
        Branch existingBranch = bank.queryBranch(branchName);
        if(existingBranch == null){
            System.out.println("Branch " + branchName + " does not exist");
            return;
        }else{
            existingBranch.printCustomerList();
        }
    }

    public static void printCustomerTransaction(){
        System.out.println("Please enter the Branch name: ");
        String branchName = scanner.nextLine();
        Branch existingBranch = bank.queryBranch(branchName);
        if(existingBranch == null){
            System.out.println("Branch " + branchName + " does not exist");
            return;
        }else{
            System.out.println("Please enter the customer name: ");
            String customerName = scanner.nextLine();
            Customer existingCustomer = existingBranch.queryCustomer(customerName);
            if(existingCustomer == null){
                System.out.println("Customer " + customerName +  " is not on file");
                return;
            }else{
                existingCustomer.printTransaction();
            }
        }
    }

}
