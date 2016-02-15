package edu.javacourse.crm.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Anton Saburov <Anton.Saburov@OCRV.RU> on 08.02.2016.
 */
@Entity
@Table(name = "CRM_PRODUCER")
@NamedQueries(
    {
        @NamedQuery(name = "CrmProduct.ProductSelect", query = "from CrmProduct where productName = :productName")
    }
)
public class CrmProducer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "producer_gen")
    @SequenceGenerator(name = "producer_gen", sequenceName = "crm_producer_producer_id_seq")
    @Column(name = "PRODUCER_ID")
    private Long producerId;

    @Column(name = "PRODUCER_NAME")
    private String producerName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "CRM_PRODUCT_PRODUCER",
            joinColumns = @JoinColumn(name = "PRODUCER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
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
