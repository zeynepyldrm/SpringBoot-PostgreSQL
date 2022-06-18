package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Product implements Serializable {

    @Id
    @SequenceGenerator(name="seq_products",allocationSize = 1)
    @GeneratedValue(generator = "seq_products",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500,name = "product_name")
    private String productName;

    @Enumerated
    private ProductType type;

    @Column(name="isDeleted")
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public enum ProductType{
        SOLID,LIQUID,GAS
    }
}
