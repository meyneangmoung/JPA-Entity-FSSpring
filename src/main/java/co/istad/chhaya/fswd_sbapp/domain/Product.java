package co.istad.chhaya.fswd_sbapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
     private String name;
     private String description;
     private double price;
     @ManyToOne
     @JoinColumn(name = "category_id", nullable = false)
        private Category category ;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
