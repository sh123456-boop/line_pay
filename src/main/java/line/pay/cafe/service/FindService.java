package line.pay.cafe.service;

import line.pay.cafe.domain.Item;
import line.pay.cafe.domain.Pay;
import line.pay.cafe.repository.*;
import lombok.RequiredArgsConstructor;
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
    public Optional<Pay> findPayById(Long id) {
        return payRepository.findById(id);
    }

    // 모든 pay 조회
    public List<Pay> findPayAll() {
        return payRepository.findAll();
    }

    public Optional<Item> findItemById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> findItemAll() {
        return itemRepository.findAll();
    }
}
