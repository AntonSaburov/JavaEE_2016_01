package edu.javacourse.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleAspect2 {

    private String aspectName;

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName;
    }

    public Object aroundTest(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("start aroundTest 2");
        Object retVal = pjp.proceed();
        System.out.println("stop aroundTest 2");
        return retVal;
    }

    public void beforeTest() {
        System.out.println("beforeTest 2");
    }

    public void afterTest() {
        System.out.println("afterTest 2");
    }
    
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }
}
