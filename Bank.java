package com.testBank;

import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branchList;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branchList = new ArrayList<Branch>();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<Branch> getBranches() {
        return branchList;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branchList = branches;
    }

    public boolean addNewBranch(Branch branch){
        if(findBranch(branch.getBranchName()) >= 0){
//            System.out.println("Branch" + branch.getBranchName() + " is already on file");
            return false;
        }
        branchList.add(branch);
        return true;
    }

    private int findBranch(String branchName){
        for(int i=0; i<this.branchList.size();i++){
            Branch branch = this.branchList.get(i);
            if(branch.getBranchName().equals(branchName)){
                return i;
            }
        }
        return -1;
    }

    public Branch queryBranch(String name){
        int position = findBranch(name);
        if (position >= 0){
            return this.branchList.get(position);
        }
        return null;
    }

    public void printBranchList(){
        System.out.println("You have " + branchList.size() + " branches");
        for (int i=0; i<branchList.size();i++){
            System.out.println((i+1) + ". " + branchList.get(i).getBranchName());
        }
    }
}
