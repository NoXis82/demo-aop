package com.noxis.demoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

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
}
