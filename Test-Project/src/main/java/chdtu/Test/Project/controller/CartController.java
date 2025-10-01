package chdtu.Test.Project.controller;

import chdtu.Test.Project.dto.CartDTO;
import chdtu.Test.Project.entity.Cart;
import chdtu.Test.Project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${end.points.cart}")
public class CartController {
    private final CartService cartService;

    @PostMapping("/{customerId}/add/{productId}")
    public ResponseEntity<CartDTO> addProductToCart(
            @PathVariable Long customerId,
            @PathVariable Long productId,
            @RequestParam(defaultValue = "1") int quantity) {

        CartDTO updatedCart = cartService.addProductToCart(customerId, productId, quantity);
        return ResponseEntity.ok().body(updatedCart);
    }

    // Видалити товар із кошика
    @DeleteMapping("/{customerId}/remove/{productId}")
    public ResponseEntity<CartDTO> removeProductFromCart(
            @PathVariable Long customerId,
            @PathVariable Long productId) {

        cartService.removeProductFromCart(customerId, productId);
        CartDTO updatedCart = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok().body(updatedCart);
    }

    // Переглянути кошик
    @GetMapping("/{customerId}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long customerId) {
        CartDTO cartDTO = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok().body(cartDTO);
    }
}
