package edu.javacourse.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Order(2)
public class SimpleAspect3 implements Ordered {

    private String aspectName;

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName;
    }

    @Around("execution(public * *(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("start doBasicProfiling 3");
        Object retVal = pjp.proceed();
        System.out.println("stop doBasicProfiling 3");
        return retVal;
    }

    @Before("execution(* edu.javacourse.spring.bean.AspectDemoBean.*(..))")
    public void beforeTest() {
        System.out.println("beforeTest 3");
    }
    
    @After("execution(public * *(..))")
    public void afterTest() {
        System.out.println("afterTest 3");
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
