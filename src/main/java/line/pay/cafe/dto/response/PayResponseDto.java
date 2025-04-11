package line.pay.cafe.dto.response;

import line.pay.cafe.domain.CardInfo;
import line.pay.cafe.domain.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class PayResponseDto {

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private CardInfo cardInfo;

    public static PayResponseDto fromEntity(line.pay.cafe.domain.Pay pay) {
        return PayResponseDto.builder()

                .amount(pay.getAmount())
                .paymentMethod(pay.getPaymentMethod())
                .cardInfo(pay.getCardInfo())
                .build();
    }
}