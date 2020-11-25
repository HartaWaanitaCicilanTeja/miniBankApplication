package com.miniBankApplicationArrayList;

import java.util.ArrayList;

public class Customer {

    private String custName;
    private ArrayList<Double> transaction;
    private double transactionAmmount;

    public Customer(String custName, double transactionAmmount) {
        this.custName = custName;
        this.transactionAmmount = transactionAmmount;
        this.transaction = new ArrayList<Double>();
        transaction.add(Double.valueOf(transactionAmmount));
    }

    public String getCustName() {
        return custName;
    }

    public Customer setCustName(String custName) {
        this.custName = custName;
        return this;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public Customer setTransaction(ArrayList<Double> transaction) {
        this.transaction = transaction;
        return this;
    }

    public double getTransactionAmmount() {
        return transactionAmmount;
    }

    public Customer setTransactionAmmount(double transactionAmmount) {
        this.transactionAmmount = transactionAmmount;
        return this;
    }


}