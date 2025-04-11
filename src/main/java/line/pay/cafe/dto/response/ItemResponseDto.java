package line.pay.cafe.dto.response;

import line.pay.cafe.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class ItemResponseDto {

    private String name;
    private BigDecimal price;

    public static ItemResponseDto fromEntity(Item  item) {
        return ItemResponseDto.builder()
                .name(item.getName())
                .price(item.getPrice())
                .build();
    }

}
