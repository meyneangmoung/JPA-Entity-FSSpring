package co.istad.chhaya.fswd_sbapp.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank
        String name,
        @Positive
        @NotNull
        BigDecimal price,

        @Positive
        @NotNull
        @Min(1)
        @Max(500)
        Integer Qty,
        String description,
        @Positive
        @NotNull
        Integer categoryId


) {
}
