package edu.javacourse.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Order(1)
public class SimpleAspect1 {

    private String aspectName;

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName;
    }

    @Around("execution(public * *(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("start doBasicProfiling 1:" + pjp.getSignature().toString());
        Object retVal = pjp.proceed();
        System.out.println("stop doBasicProfiling 1");
        return retVal;
    }

    @Before("execution(public * *(..))")
    public void beforeTest() {
        System.out.println("beforeTest 1");
    }

    @After("execution(public * *(..))")
    public void afterTest() {
        System.out.println("afterTest 1");
    }
}
