package com.testBank;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> branchCustomerList;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.branchCustomerList = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public static Branch addNewBranch(String branchName){
        return new Branch(branchName);
    }

    public boolean addNewCustomer(Customer customer){
        if(findCustomer(customer.getCustomerName()) >= 0){
//            System.out.println("Customer "+ customer + " is already on file");
            return false;
        }
        //       customer.getTransactions().add(Double.valueOf(customer.getTransactionAmount()));
        branchCustomerList.add(customer);
        return true;
    }

    private int findCustomer(String customerName){
        for(int i=0; i<this.branchCustomerList.size();i++){
            Customer customer = this.branchCustomerList.get(i);
            if(customer.getCustomerName().equals(customerName)){
                return i;
            }
        }
        return -1;
    }

    public Customer queryCustomer(String name){
        int position = findCustomer(name);
        if (position >= 0){
            return this.branchCustomerList.get(position);
        }
        return null;
    }

    public void printCustomerList(){
        System.out.println("You have " + branchCustomerList.size() + " customers in your branch");
        for (int i=0; i<branchCustomerList.size();i++){
            System.out.println((i+1) + ". " + branchCustomerList.get(i).getCustomerName() + " " + branchCustomerList.get(i).getCustomerName());
        }
    }

}