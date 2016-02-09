package edu.javacourse.crm.business;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Антон on 08.02.2016.
 */
public class OrderManagerTest {

    @Test
    public void testUpdateOrder() throws Exception {
        OrderManager om = new OrderManager();
        om.updateOrder();
        System.out.println("HELLO TEST");
    }
}