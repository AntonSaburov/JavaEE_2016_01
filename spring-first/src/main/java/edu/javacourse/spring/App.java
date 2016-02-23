package edu.javacourse.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        TestBean testBean = context.getBean(TestBean.class);
        testBean.hello();
    }
}
