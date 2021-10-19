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

        Account theAccount = new Account();
        theAccountDAO.addAccount(theAccount, true);
        theAccountDAO.doWork();

        theMembershipDAO.addMembership();
        theMembershipDAO.goToSleep();

        context.close();

    }
}
