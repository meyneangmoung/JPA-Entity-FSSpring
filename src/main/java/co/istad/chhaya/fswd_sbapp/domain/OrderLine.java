package co.istad.chhaya.fswd_sbapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_lines")
public class OrderLine {
    @Id
    private UUID orderId;
    @Id
    private String productCode;

    @Column(nullable = false)
    private Integer qty ;
    @Column(nullable = false)
    private BigDecimal unitPrice;
    @Column(nullable = false)
    private Float discount ;
}
