package edu.javacourse.crm.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
@Entity
@Table(name="CRM_PRODUCT")
public class CrmProduct
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="product_gen")
    @SequenceGenerator(name="product_gen", sequenceName="crm_product_product_id_seq")
    @Column(name="PRODUCT_ID")
    private Long productId;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "CRM_PRODUCT_PRODUCER",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCER_ID"))
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
