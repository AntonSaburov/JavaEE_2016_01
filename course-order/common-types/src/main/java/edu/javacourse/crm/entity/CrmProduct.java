package edu.javacourse.crm.entity;

import java.util.Set;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
public class CrmProduct
{
    private Long productId;
    private String productName;
    private Set<CrmProducer> producers;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<CrmProducer> getProducers() {
        return producers;
    }

    public void setProducers(Set<CrmProducer> producers) {
        this.producers = producers;
    }
}
