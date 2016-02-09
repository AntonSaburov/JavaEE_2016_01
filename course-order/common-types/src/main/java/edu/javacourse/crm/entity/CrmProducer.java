package edu.javacourse.crm.entity;

import java.util.Set;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
public class CrmProducer
{
    private Long producerId;
    private String producerName;
    private Set<CrmProduct> products;

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Set<CrmProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<CrmProduct> products) {
        this.products = products;
    }
}
