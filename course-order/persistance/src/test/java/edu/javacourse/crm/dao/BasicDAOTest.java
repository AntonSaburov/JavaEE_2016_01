package edu.javacourse.crm.dao;

import edu.javacourse.crm.entity.CrmOrder;
import edu.javacourse.crm.entity.CrmOrderItem;
import edu.javacourse.crm.entity.CrmProducer;
import edu.javacourse.crm.entity.CrmProduct;
import junit.framework.Assert;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 11.02.2016.
 */
public class BasicDAOTest
{
    private static final Logger log = LoggerFactory.getLogger(BasicDAOTest.class);

    @BeforeClass
    public static void init() {
        BasicDAO.init();
    }

//    @Test
    public void testAdd() {
        BasicDAO dao = new BasicDAO();

        CrmProducer pr = new CrmProducer();
        pr.setProducerId(1L);
        pr.setProducerName("Producer");
        dao.addEntity(pr);

        CrmProduct pt = new CrmProduct();
        pt.setProductName("Product");
        Set<CrmProducer> ps = new HashSet<CrmProducer>();
        ps.add(pr);
        pt.setProducers(ps);
        dao.addEntity(pt);
    }

//    @Test
    public void testCrud() {
        BasicDAO dao = new BasicDAO();
        CrmProducer p = new CrmProducer();
        p.setProducerName("Super Mega Product");
        dao.addEntity(p);

        p.setProducerName("Super New Mega Product");
        dao.updateEntity(p);

        CrmProducer p1 = (CrmProducer) dao.getEntity(CrmProducer.class, p.getProducerId());
//        CrmProduct p1 = (CrmProduct) dao.getEntity(CrmProduct.class, p.getProductId());
//        assertTrue(p1.getProductId().equals(p.getProductId()));
//        assertTrue(p1 instanceof CrmProduct);

        dao.deleteEntity(p);
    }

//    @Test
    public void testOrder() {
        BasicDAO dao = new BasicDAO();

        CrmOrder order = new CrmOrder();
        order.setOrderNumber("12345");
        order.setOrderDate(new Date());
        order.setUser("User");

        List<CrmOrderItem> list = new ArrayList<>();
        CrmProduct product = (CrmProduct) dao.getEntity(CrmProduct.class, 1L);
        for(int i=0; i<10; i++) {
            CrmOrderItem orderItem = new CrmOrderItem();
            orderItem.setOrder(order);
            orderItem.setPrice((i+1)*10.0);
            orderItem.setQuantity(i+1);
            orderItem.setProduct(product);
            list.add(orderItem);
        }
        order.setItems(list);

        dao.addEntity(order);
    }

//    @Test
    public void testLazy() {
        Session session = BasicDAO.sessionFactory.getCurrentSession();
        session.beginTransaction();

        CrmOrder order = (CrmOrder)session.get(CrmOrder.class, 3L);
//        order.setOrderDate(new Date());
//        Hibernate.initialize(order.getItems());
//        Hibernate.initialize(order.getItems().get(0).getProduct());
//        Integer s = order.getItems().size();
//        String name = order.getItems().get(0).getProduct().getProductName();

        List<CrmOrder> list = (List<CrmOrder>)session.createQuery("from CrmOrder").list();
//        list.get(0).getItems().size();

        session.getTransaction().commit();
    }

//    @Test
    public void testCriteria() {
        Session s = BasicDAO.sessionFactory.getCurrentSession();
        s.beginTransaction();
        Criteria criteria1 = s.createCriteria(CrmProduct.class)
                .add(Restrictions.or(
                        Restrictions.like("productName", "Pro%"),
                        Restrictions.or(
                                Restrictions.like("productName", "Supe%")
                        )))
                .addOrder(Order.asc("productName"));

        criteria1.setMaxResults(50);
        List<CrmProduct> pr = (List<CrmProduct>)criteria1.list();
    }

    @Test
    public void testHQL() {
        Session s = BasicDAO.sessionFactory.getCurrentSession();
        s.beginTransaction();

        s.createQuery("SELECT Crm FROM CrmOrder as Crm").list();
        Query query = s.getNamedQuery("CrmProduct.ProductSelect");
        query.setString("productName", "Supe Mega Product");
        query.list();
    }

//    @Test
    public void testAll() {
        BasicDAO dao = new BasicDAO();
        dao.init();

        dao.testMany();
    }
}