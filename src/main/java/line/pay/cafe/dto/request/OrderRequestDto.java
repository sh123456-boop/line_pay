package line.pay.cafe.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import line.pay.cafe.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDto {

    @NotNull
    @Valid
    private List<OrderItemRequestDto> orderItemRequestDtos;
    private List<PayRequestDto> payRequestDto;
    private MerchantRequestDto merchantRequestDto;

    private BigDecimal totalPrice;

    public Order toEntity(BigDecimal totalPrice) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(totalPrice);
        return order;
    }










}
