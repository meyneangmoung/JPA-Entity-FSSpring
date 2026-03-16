package co.istad.chhaya.fswd_sbapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor

public class Product {
    @Id
    private String Code;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer qty;
    @Column(columnDefinition = "Text")
    private String description;
    @Column(nullable = false)
    private Boolean isAvailable;
    //Relationship Jpa
    @ManyToOne
    private Category category;
}
