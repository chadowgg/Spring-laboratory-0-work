package chdtu.Test.Project.dto;

import chdtu.Test.Project.entity.Cart;
import chdtu.Test.Project.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private Long id;

    private Product product;

    private int quantity;
}
