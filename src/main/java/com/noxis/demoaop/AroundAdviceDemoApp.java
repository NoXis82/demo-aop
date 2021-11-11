package com.noxis.demoaop;

import com.noxis.demoaop.service.TrafficFortuneService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AroundAdviceDemoApp {

    public static void main(String[] args) {
        //SpringApplication.run(DemoAopApplication.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundAdviceDemoApp");
        System.out.println("Calling getFortune method");

        String data = service.getFortune();

        System.out.println("\nResult data: " + data);
        System.out.println("Finished");

        context.close();

    }
}
