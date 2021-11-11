package com.noxis.demoaop;

import com.noxis.demoaop.service.TrafficFortuneService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class AroundAdviceDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundAdviceDemoApp.class.getName());

    public static void main(String[] args) {
        //SpringApplication.run(DemoAopApplication.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundAdviceDemoApp");
        myLogger.info("\nMain Program: AroundAdviceDemoApp");
        System.out.println("Calling getFortune method");
        myLogger.info("Calling getFortune method");

        String data = service.getFortune();

        System.out.println("\nResult data: " + data);
        myLogger.info("\nResult data: " + data);
        System.out.println("Finished");
        myLogger.info("Finished");

        context.close();

    }
}
