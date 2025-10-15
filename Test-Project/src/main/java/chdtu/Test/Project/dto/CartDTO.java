package chdtu.Test.Project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Long cartId;

    private Long customerId;

    private String customerFullName;

    private List<CartItemDTO> items;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;
}
