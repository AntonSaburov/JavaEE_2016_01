package edu.javacourse.crm.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
@Entity
@Table(name="CRM_ORDER")

public class CrmOrder
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="order_gen")
    @SequenceGenerator(name="order_gen", sequenceName="crm_order_order_id_seq")
    @Column(name="ORDER_ID")
    private Long orderId;

    @Column(name="ORDER_NUMBER")
    private String orderNumber;

    @Column(name="ORDER_USER")
    private String user;

    @Column(name="ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private List<CrmOrderItem> items;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<CrmOrderItem> getItems() {
        return items;
    }

    public void setItems(List<CrmOrderItem> items) {
        this.items = items;
    }
}
