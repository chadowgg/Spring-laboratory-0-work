package chdtu.Test.Project.service;

import chdtu.Test.Project.dto.CartDTO;
import chdtu.Test.Project.entity.Cart;

import java.util.Optional;

public interface CartService {
    CartDTO addProductToCart(Long customerId, Long productId, int quantity);
    void removeProductFromCart(Long customerId, Long productId);

    CartDTO getCartByCustomerId(Long customerId);
}
