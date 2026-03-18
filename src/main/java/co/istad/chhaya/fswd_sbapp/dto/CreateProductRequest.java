package co.istad.chhaya.fswd_sbapp.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank(message ="Product name is required ")
        String name,
        @Positive
        @NotNull(message = "Price is required ")
        BigDecimal price,

        @Positive
        @NotNull(message = "QTY is required")
        @Min(1)
        @Max(500)
        Integer qty,

        String description,
        @Positive
        @NotNull(message ="Category is required")
        Integer categoryId


) {
}
