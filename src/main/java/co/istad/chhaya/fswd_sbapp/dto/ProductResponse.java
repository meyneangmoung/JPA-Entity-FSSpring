package co.istad.chhaya.fswd_sbapp.dto;

import lombok.Builder;
import org.springframework.javapoet.MethodSpec;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        String code,
        String name,
        BigDecimal price,
        String description,
        Boolean isAvailable,
        Integer qty

) {

}
