package com.noxis.demoaop.aspect;

import com.noxis.demoaop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    //add @afterReturning
    @AfterReturning(
            pointcut = "execution(* com.noxis.demoaop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result
    ) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ====>>> Execution @AfterReturning on method: " + method);
        System.out.println("\n ====>>> Result is: " + result);

        //let's post-process
        convertAccountNamesToUpperCase(result);

        System.out.println("\n ====>>> UpperCase Result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount: result) {
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

        //display method arguments

        //get args
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
