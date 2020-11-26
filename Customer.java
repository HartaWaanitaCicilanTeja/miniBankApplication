package com.testBank;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private double transactionAmount;
    private ArrayList<Double> transactions;

    public Customer(String customerName, double transactionAmount) {
        this.transactions = new ArrayList<Double>();
        this.customerName = customerName;
        this.transactionAmount = transactionAmount;
        transactions.add(Double.valueOf(transactionAmount));
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

    public static Customer addNewCustomer(String customerName, double transactionAmount){
        return new Customer(customerName,transactionAmount);
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public boolean addTransaction(double amount){
        getTransactions().add(Double.valueOf(amount));
        return true;
    }

    public void printTransaction(){
        System.out.println("You have " + transactions.size() + " transactions");
        for (int i=0; i<transactions.size();i++){
            System.out.println((i+1) + ". " + transactions.get(i).doubleValue());
        }
    }
}
