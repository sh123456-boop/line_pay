package line.pay.cafe.service;

import line.pay.cafe.domain.Item;
import line.pay.cafe.domain.Pay;
import line.pay.cafe.dto.response.ItemResponseDto;
import line.pay.cafe.dto.response.OrderResponseDto;
import line.pay.cafe.dto.response.PayResponseDto;
import line.pay.cafe.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindService {

    private final PayRepository payRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final MerchantRepository merchantRepository;

    // id로 단일 pay 조회
    public Optional<PayResponseDto> findPayById(Long id) {
        return payRepository.findById(id)
                .map(PayResponseDto::fromEntity);
    }

    // 모든 pay 조회
    public List<PayResponseDto> findPayAll() {
        return payRepository.findAll().stream()
                .map(PayResponseDto::fromEntity)
                .toList();
    }

    //item 조회
    public Optional<ItemResponseDto> findItemById(Long id) {
        return itemRepository.findById(id)
                .map(ItemResponseDto::fromEntity);
    }

    @Cacheable(value = "items")
    public List<ItemResponseDto> findItemAll() {
        return itemRepository.findAll().stream()
                .map(ItemResponseDto::fromEntity)
                .toList();
    }

    //orders 조회
    public Optional<OrderResponseDto> findOrderById(Long id) {
        return orderRepository.findById(id)
                .map(OrderResponseDto::fromEntity);
    }

    public List<OrderResponseDto> findOrderAll() {
        return orderRepository.findAll().stream()
                .map(OrderResponseDto::fromEntity)
                .toList();
    }

}
