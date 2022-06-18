package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Category implements Serializable {
        @Id
        @SequenceGenerator(name="seq_categories",allocationSize = 1)
        @GeneratedValue(generator = "seq_categories",strategy = GenerationType.SEQUENCE)
        private Long id;

        @Column(length = 500,name = "category_name")
        private String categoryName;

        @OneToMany
        @JoinColumn(name = "category_id")
        private List<Product> products;
}
