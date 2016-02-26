package edu.javacourse.spring.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleInterceptor implements MethodInterceptor
{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Before: invocation=[" + invocation.getMethod().getName() + "]");
        long d1 = System.currentTimeMillis();
        Object rval = invocation.proceed();
        long d2 = System.currentTimeMillis();
        long delta = d2 - d1;
        System.out.println("Invocation returned:" + delta);
        return rval;
    }
}