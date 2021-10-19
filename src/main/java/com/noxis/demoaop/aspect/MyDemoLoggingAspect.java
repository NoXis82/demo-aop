package com.noxis.demoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //	@Before("execution(public void addAccount())")

    //	@Before("execution(public void com.noxis.aopdemo.dao.AccountDAO.addAccount())")

    //	@Before("execution(public void add*())")

    // @Before("execution(* add*())")

   // @Before("execution(* add*(..))")

     @Before("execution(* com.noxis.demoaop.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====> Executing @before advice on method");
    }



}
