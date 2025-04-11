package line.pay.cafe.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import line.pay.cafe.domain.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemRequestDto {

    @NotNull(message = "상품은 필수입니다.")
    private Item item;

    @Min(value = 1, message = "수량은 최소 1 이상이어야 합니다.")
    private int count;
    private BigDecimal orderPrice;



}
