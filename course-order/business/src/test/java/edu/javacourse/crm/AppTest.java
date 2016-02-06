package edu.javacourse.crm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Антон on 04.02.2016.
 */
public class AppTest
{

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTest1() throws Exception {
        App p = new App();
        p.test1();
        Assert.fail();
    }

    @Test(expected = MyException.class)
    public void testTest2() throws Exception {
        App p = null;
        try {
            p.test2();
        } catch(Exception ex) {
            throw new MyException("1");
        }
    }

    @Test
    public void testTest3() throws Exception {
        App p = new App();
        p.test3();
    }
}