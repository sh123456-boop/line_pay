package line.pay.cafe.dto;

import line.pay.cafe.domain.CardInfo;
import line.pay.cafe.domain.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PayDto {

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private CardInfo cardInfo;
}
