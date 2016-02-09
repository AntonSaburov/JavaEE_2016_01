package edu.javacourse.crm.business;

import edu.javacourse.crm.dao.OrderDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
public class OrderManager
{
    private static final Logger log = LoggerFactory.getLogger(OrderManager.class);

    private OrderDAO dao;

    public void updateOrder() {
        int counter = 10;
        log.info("Info:{} {} {}", counter, counter, counter);
    }
}
