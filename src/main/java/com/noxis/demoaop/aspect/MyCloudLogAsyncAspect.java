package com.noxis.demoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {

    @Before("com.noxis.demoaop.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("====> Logging to Cloud ");
    }

}
