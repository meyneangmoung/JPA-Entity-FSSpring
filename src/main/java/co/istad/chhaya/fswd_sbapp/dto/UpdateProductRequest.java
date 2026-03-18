package co.istad.chhaya.fswd_sbapp.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record UpdateProductRequest(
        String name,
        @Positive(message = "Product can not negative")
        BigDecimal price,
        @Positive(message = "Quantity must be less then 300 products")
        Integer qty,
        String description

){
}