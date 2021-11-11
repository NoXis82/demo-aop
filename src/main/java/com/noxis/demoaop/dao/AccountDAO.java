package com.noxis.demoaop.dao;


import com.noxis.demoaop.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire) {
        // simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();
        // create test sample accounts
        Account temp1 = new Account("Name Temp 1", "Level Temp 1");
        Account temp2 = new Account("Name Temp 2", "Level Temp 2");
        Account temp3 = new Account("Name Temp 3", "Level Temp 3");
        // add to list test accounts
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY WORK Adding Account!!!\n");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()\n");
        return true;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()\n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()\n");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()\n");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()\n");
        this.serviceCode = serviceCode;
    }

}
