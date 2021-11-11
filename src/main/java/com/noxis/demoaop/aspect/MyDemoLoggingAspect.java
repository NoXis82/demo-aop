package com.noxis.demoaop.aspect;

import com.noxis.demoaop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.noxis.demoaop.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @Around on method: " + method);
        myLogger.info("\n====> Executing @Around on method: \" + method");
        long begin = System.currentTimeMillis();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception err) {
            System.out.println("@Around advice: We have a problem " + err);
            myLogger.warning(err.getMessage());
            result = "Nothing exciting here. Move along!";
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("\n====> Duration: " + duration / 1000 + " sec");
        myLogger.info("\n====> Duration: " + duration / 1000 + " sec");
        return result;
    }

    @After("execution(* com.noxis.demoaop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ====>>> Execution @After (finally) on method: " + method);
    }

    // add @AfterThrowing
    @AfterThrowing(
            pointcut = "execution(* com.noxis.demoaop.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ====>>> Execution @AfterThrowing on method: " + method);
        System.out.println("\n ====>>> The exception is: " + theExc);
    }

    //add @AfterReturning
    @AfterReturning(
            pointcut = "execution(* com.noxis.demoaop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ====>>> Execution @AfterReturning on method: " + method);
        System.out.println("\n ====>>> Result is: " + result);

        //let's post-process
        convertAccountNamesToUpperCase(result);

        System.out.println("\n ====>>> UpperCase Result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.noxis.demoaop.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("====> Executing @Before advice on method");

        //display method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSig);

        //display method arguments ans get args
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }

}
