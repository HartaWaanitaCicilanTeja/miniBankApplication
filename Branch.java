package com.miniBankApplicationArrayList;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> branchCustomer;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.branchCustomer = new ArrayList<Customer> ();
    }

    public String getBranchName() {
        return branchName;
    }

    public Branch setBranchName(String branchName) {
        this.branchName = branchName;
        return this;
    }

    public ArrayList<Customer> getBranchCustomer() {
        return branchCustomer;
    }

    public Branch setBranchCustomer(ArrayList<Customer> branchCustomer) {
        this.branchCustomer = branchCustomer;
        return this;
    }

}