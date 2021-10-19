package com.noxis.demoaop.dao;


import com.noxis.demoaop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY WORK Adding Account!!!");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return true;
    }
}
