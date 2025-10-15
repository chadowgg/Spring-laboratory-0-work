package chdtu.Test.Project.dto;

import chdtu.Test.Project.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private Long id;

    private String productName;

    private Integer price;

    private Integer quantityInStock;

    private Category category;

    private String productDescription;
}
