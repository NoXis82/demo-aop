package com.noxis.demoaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMembership() {
        System.out.println(getClass() + ": DOING MY addMembership WORK!!!");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + "goto to sleep");
    }

}
