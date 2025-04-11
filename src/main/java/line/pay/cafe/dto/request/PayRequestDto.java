package line.pay.cafe.dto.request;

import line.pay.cafe.domain.CardInfo;
import line.pay.cafe.domain.PaymentMethod;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PayRequestDto {

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private CardInfo cardInfo;
}
