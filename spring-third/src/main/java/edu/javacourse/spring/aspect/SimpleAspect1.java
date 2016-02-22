package edu.javacourse.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleAspect1 {

    private String aspectName;

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName;
    }

    public Object aroundTest(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for(Object arg : args) {
            System.out.println(arg.getClass().getSimpleName());
            System.out.println(arg.toString());
        }
        System.out.println("start aroundTest 1 :" + pjp);
        Object retVal = pjp.proceed();
        System.out.println("stop aroundTest 1");
        return retVal;
    }

    public void beforeTest() {
        System.out.println("beforeTest 1");
    }

    public void afterTest() {
        System.out.println("afterTest 1");
    }
}
