package chdtu.Test.Project.service.impl;

import chdtu.Test.Project.constants.ApiErrorMessage;
import chdtu.Test.Project.dto.CartDTO;
import chdtu.Test.Project.entity.Cart;
import chdtu.Test.Project.entity.CartItem;
import chdtu.Test.Project.entity.Customer;
import chdtu.Test.Project.entity.Product;
import chdtu.Test.Project.exception.NotFoundException;
import chdtu.Test.Project.mapper.CartMapper;
import chdtu.Test.Project.repositories.CartRepository;
import chdtu.Test.Project.repositories.CustomerRepository;
import chdtu.Test.Project.repositories.ProductRepository;
import chdtu.Test.Project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    @Override
    public CartDTO addProductToCart(Long customerId, Long productId, int quantity) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.CUSTOMER_NOT_FOUND_BY_ID.getMessage(customerId)));

        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setCustomer(customer);
                    return cartRepository.save(newCart);
                });

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.PRODUCT_NOT_FOUND_BY_ID.getMessage(customerId)));

        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseGet(() -> {
                    CartItem newItem = new CartItem();
                    newItem.setCart(cart);
                    newItem.setProduct(product);
                    newItem.setQuantity(0);
                    cart.getItems().add(newItem);
                    return newItem;
                });

        cartItem.setQuantity(cartItem.getQuantity() + quantity);

        getTotalPrice(cart);

        return cartMapper.toDto(cartRepository.save(cart));
    }

    @Override
    public void removeProductFromCart(Long customerId, Long productId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.CART_NOT_FOUND_BY_ID.getMessage(customerId)));

        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.ITEM_NOT_FOUND_BY_ID.getMessage(productId)));

        int newQuantity = cartItem.getQuantity() - 1;

        if (newQuantity > 0) {
            cartItem.setQuantity(newQuantity);
        } else {
            cart.getItems().remove(cartItem);
        }

        getTotalPrice(cart);

        if (cart.getItems().isEmpty()) {
            cartRepository.delete(cart);
        } else {
            cartRepository.save(cart);
        }
    }

    @Override
    public CartDTO updateCart(Long customerId, Long productId, int quantity) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.CART_NOT_FOUND_BY_ID.getMessage(customerId)));

        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.ITEM_NOT_FOUND_BY_ID.getMessage(productId)));
        cartItem.setQuantity(quantity);

        getTotalPrice(cart);

        return cartMapper.toDto(cartRepository.save(cart));
    }

    @Override
    public CartDTO getCartByCustomerId(Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.CART_NOT_FOUND_BY_ID.getMessage(customerId)));
        return cartMapper.toDto(cart);
    }

    @Override
    public List<CartDTO> getCartsAll() {
        List<Cart> carts = cartRepository.findAll();

        return cartMapper.toDTOs(carts);
    }

    private void getTotalPrice(Cart cart) {
        BigDecimal total = cart.getItems().stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotalPrice(total);
    }
}
