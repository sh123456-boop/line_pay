package line.pay.cafe.dto.request;

import line.pay.cafe.domain.Item;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ItemRequestDto {
    private String name;
    private BigDecimal price;

    //dto를 통해 아이템 생성
    public Item toEntity(ItemRequestDto itemDto) {
        Item item = new Item(null, itemDto.getName(), itemDto.getPrice());
        return item;
    }


}
