package line.pay.cafe.dto;

import line.pay.cafe.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private List<OrderItemDto> orderItemDtos;
    private List<PayDto> payDto;
    private MerchantDto merchantDto;

    private BigDecimal totalPrice;

    public Order toEntity(BigDecimal totalPrice) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(totalPrice);
        return order;
    }










}
