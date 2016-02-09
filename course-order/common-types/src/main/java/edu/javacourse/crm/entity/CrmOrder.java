package edu.javacourse.crm.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
public class CrmOrder
{
    private Long orderId;
    private String orderNumber;
    private String user;
    private Date orderDate;
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
