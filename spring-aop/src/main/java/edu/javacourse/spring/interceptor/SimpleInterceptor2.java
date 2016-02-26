package edu.javacourse.spring.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Антон on 25.02.2016.
 */
public class SimpleInterceptor2 implements MethodInterceptor
{
    public Object invoke(MethodInvocation m) throws Throwable {
        System.out.println("Second Interceptor Before");
        Object f = m.proceed();
        System.out.println("Second Interceptor After");
        return f;
    }
}
