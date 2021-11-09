package com.noxis.demoaop;

import com.noxis.demoaop.dao.AccountDAO;
import com.noxis.demoaop.dao.MembershipDAO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class AfterReturningDemoApp {

    public static void main(String[] args) {
        //SpringApplication.run(DemoAopApplication.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> myAccounts = theAccountDAO.findAccounts();

        System.out.println("TEST ----> AfterReturningDemo");
        System.out.println("----");
        System.out.println(myAccounts);
        System.out.println("\n");

        context.close();

    }
}
