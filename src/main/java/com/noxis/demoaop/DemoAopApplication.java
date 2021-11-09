package com.noxis.demoaop;

import com.noxis.demoaop.dao.AccountDAO;
import com.noxis.demoaop.dao.MembershipDAO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoAopApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoAopApplication.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //Account
        Account theAccount = new Account();
        theAccountDAO.addAccount(theAccount, true);
        theAccountDAO.doWork();
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");
        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        //Membership
        theMembershipDAO.addMembership();
        theMembershipDAO.goToSleep();

        context.close();

    }
}
