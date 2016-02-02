package edu.javacourse.refl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Антон on 25.01.2016.
 */
public class Example
{
    public static void main(String[] args) throws Exception {

        String s = "234";
        Class a = s.getClass();
        Class fc = Class.forName("javax.swing.JFrame");
        Object jf = fc.newInstance();

        Field f = fc.getDeclaredField("f");
        f.set(s, "asdfsdfasdfasdf");
        f.get(s);
        Annotation[] an = f.getAnnotations();

        Method m = fc.getMethod("setField", null);
        m.invoke(s, null);
        m.getAnnotations();
    }
}
