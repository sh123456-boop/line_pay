package line.pay.cafe.controller;

import line.pay.cafe.domain.Item;
import line.pay.cafe.dto.response.ItemResponseDto;
import line.pay.cafe.dto.response.OrderResponseDto;
import line.pay.cafe.dto.response.PayResponseDto;
import line.pay.cafe.service.FindService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FindController {

    private final FindService findService;

    // Item
    @GetMapping("/item/{id}")
    public ResponseEntity<ItemResponseDto> getItemById(@PathVariable Long id) {
        return findService.findItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/item/all")
    public List<ItemResponseDto> getAllItems() {
        return findService.findItemAll();
    }

    //Pay
    @GetMapping("/pay/{id}")
    public ResponseEntity<PayResponseDto> getPayById(@PathVariable Long id) {
        return findService.findPayById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/pay/all")
    public List<PayResponseDto> getAllPays() {
        return findService.findPayAll();
    }

    // Order
    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long id) {
        return findService.findOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/order/all")
    public List<OrderResponseDto> getAllOrders() {
        return findService.findOrderAll();
    }

}
