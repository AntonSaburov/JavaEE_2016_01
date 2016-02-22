package edu.javacourse.spring.bean;

public class AspectDemoBean {

    public void testAspect(String name) {
        System.out.println("testAspect:" + name);
    }
    
    public void testThrow() {
        System.out.println("testThrow");
        throw new RuntimeException("He");
    }
}
