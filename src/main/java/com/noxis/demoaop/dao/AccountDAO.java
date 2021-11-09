package com.noxis.demoaop.dao;


import com.noxis.demoaop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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
