package edu.javacourse.crm.entity;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
public class CrmOrderItem
{
    private Long orderItemId;
    private CrmOrder order;
    private CrmProduct product;
    private Double price;
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
