package chdtu.Test.Project.controller;

import chdtu.Test.Project.dto.CartDTO;
import chdtu.Test.Project.entity.Cart;
import chdtu.Test.Project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${end.points.cart}")
public class CartController {
    private final CartService cartService;

    @PostMapping("${end.points.addToCart}")
    public ResponseEntity<CartDTO> addProductToCart(
            @PathVariable Long customerId,
            @PathVariable Long productId,
            @RequestParam(defaultValue = "1") int quantity) {

        CartDTO addProductToCartCart = cartService.addProductToCart(customerId, productId, quantity);
        return ResponseEntity.ok().body(addProductToCartCart);
    }

    @PatchMapping("${end.points.updateCart}")
    public ResponseEntity<CartDTO> updateCart(
            @PathVariable Long customerId,
            @PathVariable Long productId,
            @PathVariable int quantity) {
        CartDTO updateCart = cartService.updateCart(customerId, productId, quantity);
        return ResponseEntity.ok().body(updateCart);
    }

    @DeleteMapping("${end.points.deleteCartItem}")
    public ResponseEntity<CartDTO> removeProductFromCart(
            @PathVariable Long customerId,
            @PathVariable Long productId) {

        cartService.removeProductFromCart(customerId, productId);
        CartDTO updatedCart = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok().body(updatedCart);
    }

    @GetMapping("${end.points.getCart}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long customerId) {
        CartDTO cartDTO = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok().body(cartDTO);
    }

    @GetMapping("${end.points.getCartsAll}")
    public ResponseEntity<List<CartDTO>> getCarts() {
        List<CartDTO> cartDTOList = cartService.getCartsAll();
        return ResponseEntity.ok().body(cartDTOList);
    }

}
