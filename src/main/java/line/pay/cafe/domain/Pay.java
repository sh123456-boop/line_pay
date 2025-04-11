package line.pay.cafe.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private BigDecimal amount; //주문 금액

    @Enumerated(EnumType.STRING) //string인 이유
    private PaymentMethod paymentMethod;

    @Embedded
    private CardInfo cardInfo;

    public Pay() {
    }


}
