package line.pay.cafe.service;

import line.pay.cafe.domain.*;
import line.pay.cafe.dto.request.MerchantRequestDto;
import line.pay.cafe.dto.request.OrderItemRequestDto;
import line.pay.cafe.dto.request.OrderRequestDto;
import line.pay.cafe.dto.request.PayRequestDto;
import line.pay.cafe.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaveService {

    private final PayRepository payRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final MerchantRepository merchantRepository;



    //orderDto와 order를 통해 orderItem생성
    public static List<OrderItem> createOrderItems(Order order, List<OrderItemRequestDto> orderItemRequestDtos, ItemRepository itemRepository) {
        List<OrderItem> list = new ArrayList<>();


        for( OrderItemRequestDto dto : orderItemRequestDtos) {
            OrderItem orderItem1 = new OrderItem();

            //아이템 저장
            Item item = dto.getItem();
            itemRepository.save(item);
            orderItem1.setItem(dto.getItem());
            orderItem1.setCount(dto.getCount());
            //연관관계 메서드
            orderItem1.setOrderPrice(dto.getOrderPrice());
            order.addOrderItem(orderItem1);
            list.add(orderItem1);
        }
        return list;
    }

    //MerchantDto와 order를 통해 merchant생성
    public static  Merchant createMerchant(MerchantRequestDto merchantRequestDto, Order order) {
        Merchant merchant = new Merchant(null, merchantRequestDto.getName(), merchantRequestDto.getBusinessNumber(), LocalDateTime.now());
        //연관관계 메서드
        order.setMerchant(merchant);
        return merchant;
    }

    //PayDto와 order를 통해 pay 생성
    public static Pay createPay(Order order, List<PayRequestDto> payRequestDto) {
        Pay pay = new Pay();
        for (PayRequestDto dto : payRequestDto) {
            pay.setAmount(dto.getAmount());
            pay.setCardInfo(dto.getCardInfo());
            pay.setPaymentMethod(dto.getPaymentMethod());
        }
        order.addPay(pay);
        return pay;
    }

    public void save(OrderRequestDto orderRequestDto) {
        //order 생성 및 저장
        Order order = orderRequestDto.toEntity(orderRequestDto.getTotalPrice());
        //연관관계 주입 후 order 저장
        orderRepository.save(order);

        //orderItem 생성 및 저장
        List<OrderItem> orderItems = SaveService.createOrderItems(order, orderRequestDto.getOrderItemRequestDtos(), itemRepository);
        for (OrderItem orderItem : orderItems) {
            orderItemRepository.save(orderItem);
        }

        //merchant 생성 및 저장
        Merchant merchant = SaveService.createMerchant(orderRequestDto.getMerchantRequestDto(), order);
        merchantRepository.save(merchant);

        //pay 생성 및 저장
        Pay pay = SaveService.createPay(order, orderRequestDto.getPayRequestDto());
        payRepository.save(pay);
    }

    public Optional<Order> findById(Long orderId) {
        return orderRepository.findById(orderId);
    }


}
