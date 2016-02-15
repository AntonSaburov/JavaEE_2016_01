package edu.javacourse.crm.entity;

import javax.persistence.*;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
@Entity
@Table(name="CRM_ORDER_ITEM")
public class CrmOrderItem
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="order_item_gen")
    @SequenceGenerator(name="order_item_gen", sequenceName="crm_order_item_order_item_id_seq")
    @Column(name="ORDER_ITEM_ID")
    private Long orderItemId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private CrmOrder order;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private CrmProduct product;

    @Column(name="PRICE")
    private Double price;

    @Column(name="QUANTITY")
    private Integer quantity;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public CrmOrder getOrder() {
        return order;
    }

    public void setOrder(CrmOrder order) {
        this.order = order;
    }

    public CrmProduct getProduct() {
        return product;
    }

    public void setProduct(CrmProduct product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
