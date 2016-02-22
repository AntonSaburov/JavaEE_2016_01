package edu.javacourse.spring;

import edu.javacourse.spring.bean.AspectDemoBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleExample {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});
        
        AspectDemoBean adb = context.getBean(AspectDemoBean.class);
        adb.testAspect();
    }
}
