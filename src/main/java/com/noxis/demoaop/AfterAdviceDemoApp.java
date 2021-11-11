package com.noxis.demoaop;

import com.noxis.demoaop.dao.AccountDAO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class AfterAdviceDemoApp {

    public static void main(String[] args) {
        //SpringApplication.run(DemoAopApplication.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> myAccounts = null;
        try {
            // add boolean flag to simulate exception
            boolean tripWire = true;
            theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain Program... caught exception: " + e);
        }
        System.out.println("TEST ----> AfterReturningDemo");
        System.out.println("----");
        System.out.println(myAccounts);
        System.out.println("\n");

        context.close();

    }
}
