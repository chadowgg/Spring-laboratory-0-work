package chdtu.Test.Project.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiErrorMessage {
    PRODUCT_NOT_FOUND_BY_ID("Product with ID: %s was not found"),
    PRODUCT_ALREADY_EXISTS("Product with Title: %s already exists"),
    CUSTOMER_ALREADY_EXISTS("Customer with ID: %s already exists"),
    CUSTOMER_NOT_FOUND_BY_ID("Customer with ID: %s was not found"),
    ITEM_NOT_FOUND_BY_ID("Item with ID: %s was not found"),
    CART_NOT_FOUND_BY_ID("Cart with ID: %s was not found"),
    CUSTOMER_NOT_FOUND("Customer with ID: %s was not found"),
    ;

    private final String message;

    public String getMessage(Object... args
    ) {
        return String.format(message, args);
    }
}
