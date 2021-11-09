package com.noxis.demoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.noxis.demoaop.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.noxis.demoaop.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.noxis.demoaop.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNotGetterSetter() {
    }

    @Before("forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("====> Executing @Before advice on method");
    }

    @Before("forDaoPackageNotGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("====> Perform API analytics");
    }

}
