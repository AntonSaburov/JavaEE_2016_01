package edu.javacourse.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Order(3)
public class SimpleAspect2 {

    private String aspectName;

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName;
    }

    @Around("execution(public * *(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("start doBasicProfiling 2");
        Object retVal = pjp.proceed();
        System.out.println("stop doBasicProfiling 2");
        return retVal;
    }

    @Before("execution(public * *(..))")
    public void beforeTest() {
        System.out.println("beforeTest 2");
    }

    @After("execution(public * *(..))")
    public void afterTest() {
        System.out.println("afterTest 2");
    }
}
