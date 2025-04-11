package line.pay.cafe.controller;

import line.pay.cafe.dto.ItemRequestDto;
import line.pay.cafe.dto.OrderDto;
import line.pay.cafe.dto.SaveRequestDto;
import line.pay.cafe.service.SaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SaveController {

    private final SaveService saveService;

    @PostMapping("/domain")
    public String save(@RequestBody SaveRequestDto saveRequestDto) {
        OrderDto orderDto = saveRequestDto.getOrderDto();
        ItemRequestDto itemDto = saveRequestDto.getItemDto();
        saveService.save(orderDto);
        return "OK";
    }


}
