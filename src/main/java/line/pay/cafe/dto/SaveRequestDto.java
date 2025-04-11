package line.pay.cafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveRequestDto {
    private OrderDto orderDto;
    private ItemRequestDto itemDto;
}
