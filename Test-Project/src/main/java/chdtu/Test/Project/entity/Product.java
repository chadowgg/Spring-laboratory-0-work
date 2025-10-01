package chdtu.Test.Project.entity;

import chdtu.Test.Project.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    private Integer price;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "product_description")
    private String productDescription;
}
