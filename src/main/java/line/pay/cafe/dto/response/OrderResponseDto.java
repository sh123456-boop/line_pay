package line.pay.cafe.dto.response;

import line.pay.cafe.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class OrderResponseDto {
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;

    private MerchantResponseDto merchant;
    private List<OrderItemResponseDto> orderItems;
    private List<PayResponseDto> payments;

    public static OrderResponseDto fromEntity(Order order) {
        return OrderResponseDto.builder()
                .totalPrice(order.getTotalPrice())
                .orderDate(order.getOrderDate())
                .merchant(MerchantResponseDto.fromEntity(order.getMerchant()))
                .orderItems(order.getOrderItems().stream()
                        .map(OrderItemResponseDto::fromEntity)
                        .collect(Collectors.toList()))
                .payments(order.getPayments().stream()
                        .map(PayResponseDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
