package com.noxis.demoaop.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class TrafficFortuneService {

    public String getFortune() {
        //simulate to delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return "Expect heavy traffic today...";
    }
}
