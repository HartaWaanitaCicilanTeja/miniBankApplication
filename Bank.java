package com.miniBankApplicationArrayList;


import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;
    private ArrayList<Customer> branchCustomer;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
        this.branchCustomer = new ArrayList<Customer>();
    }


    public String getBankName() {
        return bankName;
    }

    public Bank setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public Bank setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
        return this;
    }

    public ArrayList<Customer> getBranchCustomer() {
        return branchCustomer;
    }

    public Bank setBranchCustomer(ArrayList<Customer> branchCustomer) {
        this.branchCustomer = branchCustomer;
        return this;
    }

    public void printListCustomer(String bankName) {

        //System.out.println("You have " + branchCustomer.size() + " list customer");
        for (Branch b : branches) {
            for (Customer c: branchCustomer) {


            //            for (int i = 0; i < branchCustomer.size(); i++) {
                if (b.getBranchName().equals(bankName)) {
                    System.out.println(b.getBranchName() + "  : " +c.getCustName());

                    // for (int j = 0; j < branches.size(); j++)
                    //System.out.println((i + 1) + ". " + branchCustomer.get(i).getCustName()+ " " +bankName);//+ " : " + branches.get(j).getBranchName());
                } else {
                    System.out.println("your branch name not in your list");
                }

            }
        }
    }


       /*
        Branch branch = new Branch(bankName);
        ArrayList<Customer> customers = new ArrayList<Customer>();

        *//*
         terakhir sampai sini belum bisa print list customer
         Berdasarkan nama cabang yang di input
         *//*
        if (bankName.equals(getBankName())) {
            for (int i = 0; i <branchCustomer.size() ; i++) {
                if (branchCustomer.get(i).getCustName().equals(bankName)) {


                }
            }
            for (Customer c : branchCustomer) {
                if (branchCustomer.isEmpty()) {
                    System.out.println(" there is no list customer in your list system");
                } else {
                    System.out.println(c.getCustName());
                }
                System.out.println(c.getCustName());
            }
        }else {
            System.out.println(" there is no list customer in your list system");
        }
        */


    public void addNewCustomer(String branchName, String custName, Double transactionAmmount) {
        Branch branch = new Branch(branchName);
        Customer cust = new Customer(custName, transactionAmmount);
        if (findCustName(custName) < 0 && (transactionAmmount > 1000)) {
            branchCustomer.add(cust);
            branches.add(branch);
            System.out.println(custName + " your data has been insert successfull");
        } else if (findCustName(custName) > 0 && transactionAmmount <= 1000 && findBranchName(branchName) > 0) {
            System.out.println("the cust " + cust.getCustName() + " not in your systems");
        }

    }


    private int findCustName(String custName) {
        for (int i = 0; i < branchCustomer.size(); i++) {
            if (branchCustomer.get(i).getCustName().equals(custName)) {
                return i;
            }
        }
        return -1;
    }

    public void updateCustName(String custName, String newCustName) {
        int index = findCustName(custName);
        if (custName.equals(newCustName)) {
            System.out.println(" your contact name " + custName + " cannot be changed because the " + newCustName +
                    " Already Exist ");
        } else if (index > 0) {
            branchCustomer.get(index).setCustName(newCustName);
            System.out.println(" your contact name " + custName + " has been Changed to " + newCustName);
        } /*else  if (findContactName(newName)!=-1){
            System.out.println(" your contact name " + name + " cannot be changed because the " + newName +
                    " Already Exist ");
        }*/ else {
            System.out.println(" the name " + custName + " not in your contact list ");
        }
    }

    public void deleteCust(String custName) {
        int index = findCustName(custName);
        if (index >= 0) {
            branchCustomer.remove(index);

            System.out.println(" Your contacts " + custName + " has been removed");
        } else {
            System.out.println(" No contacts name" + custName + " in your contact list");

        }
    }

    public boolean onFile(String custName) {
        int index = findCustName(custName);
        if (index >= 0) {
            return true;
        }
        return false;
    }

    private int findBranchName(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewBranch(String branchName) {
        Branch branch = new Branch(branchName);
        if (findBranchName(branchName) < 0) {
            branches.add(branch);
            System.out.println(" the branch Name " + branch.getBranchName() + " success insert into systems ");
            //   return true;
        /*
        } else if (findCustName(custName) > 0) {
            System.out.println(" the cust " + cust.getCustName() + " cant insert into systems because already exists");
            */
        } else { //if (transactionAmmount <= 1000) {
            System.out.println(" the branch Name " + branch.getBranchName() + " cant insert into systems because already exists");
        }
        //return false;
    }

    public void updateBranchName(String branchName, String newBranchName) {
        int index = findBranchName(branchName);
        if (branchName.equals(newBranchName)) {
            System.out.println(" your contact name " + branchName + " cannot be changed because the " + newBranchName +
                    " Already Exist ");
        } else if (index > 0) {
            branches.get(index).setBranchName(newBranchName);
            System.out.println(" your contact name " + branchName + " has been Changed to " + newBranchName);
        } /*else  if (findBranchName(branchName)!=-1){
            System.out.println(" your branch name " + branchName + " cannot be changed because the " + newBranchName +
                    " Already Exist ");
        }*/ else {
            System.out.println(" the name " + branchName + " not in your contact list ");
        }
    }

    public void deleteBranch(String branchName) {
        int index = findBranchName(branchName);
        if (index >= 0) {
            branches.remove(index);

            System.out.println(" Your contacts " + branchName + " has been removed");
        } else {
            System.out.println(" No contacts name" + branchName + " in your contact list");

        }
    }

    public void printListBranch() {
        System.out.println("You have " + branches.size() + " list branch");
        for (Branch b : branches) {
            if (branches.isEmpty()) {
                System.out.println(" there is no list customer in your list system");
            }
            System.out.println(b.getBranchName());
        }
    }

    public Customer queryCust(String custName) {
        int position = findCustName(custName);
        if (position >= 0) {
            return this.branchCustomer.get(position);
        }
        return null;
    }

    public void additionalBalance(String custName, Double transactionAmmount) {
        Customer customer = new Customer(custName, transactionAmmount);
        int cust = findCustName(custName);//new Customer(custName, transactionAmmount);
        double additionalBalance = 0;
        if (cust < 0) {
            System.out.println("Customer " + custName + " is not on file");
            return;
        } else {
            additionalBalance += customer.getTransactionAmmount();
        }
    }

    public Branch queryBranch(String name) {
        int position = findBranchName(name);
        if (position >= 0) {
            return this.branches.get(position);
        }
        return null;
    }
    /*public boolean addNewCustomer(String custName, Double transactionAmmount) {
        Customer cust = new Customer(custName, transactionAmmount);
        if (findCustName(custName) < 0 && transactionAmmount > 1000) {
            branchCustomer.add(cust);
            return true;
        } else if (findCustName(custName) > 0) {
            System.out.println(" the cust " + cust.getCustName() + " cant insert into systems because already exists");
        } else if (transactionAmmount <= 1000) {
            System.out.println(" the cust " + cust.getTransactionAmmount() + " cant insert into systems because max deposit is 1000");
        }
        return false;
    }
    * */
}

