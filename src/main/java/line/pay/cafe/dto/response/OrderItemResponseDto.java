package line.pay.cafe.dto.response;

import line.pay.cafe.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class OrderItemResponseDto {
    private String itemName;
    private BigDecimal orderPrice;
    private int count;

    public static OrderItemResponseDto fromEntity(line.pay.cafe.domain.OrderItem entity) {
        Item item = entity.getItem();
        return OrderItemResponseDto.builder()
                .itemName(item.getName())
                .orderPrice(entity.getOrderPrice())
                .count(entity.getCount())
                .build();
    }
}
