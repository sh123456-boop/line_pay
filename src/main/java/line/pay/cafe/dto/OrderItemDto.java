package line.pay.cafe.dto;

import line.pay.cafe.domain.Item;
import line.pay.cafe.domain.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDto {

    private Item item;
    private int count;
    private BigDecimal orderPrice;



}
