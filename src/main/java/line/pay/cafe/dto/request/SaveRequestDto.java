package line.pay.cafe.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveRequestDto {

    @NotNull(message = "주문 정보는 필수입니다.")
    @Valid
    private OrderRequestDto orderRequestDto;
    private ItemRequestDto itemRequestDto;
}
