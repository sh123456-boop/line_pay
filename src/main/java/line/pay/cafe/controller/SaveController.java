package line.pay.cafe.controller;

import jakarta.validation.Valid;
import line.pay.cafe.dto.request.ItemRequestDto;
import line.pay.cafe.dto.request.OrderRequestDto;
import line.pay.cafe.dto.request.SaveRequestDto;
import line.pay.cafe.service.SaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SaveController {

    private final SaveService saveService;

    @PostMapping("/domain")
    public String save(@Valid @RequestBody SaveRequestDto saveRequestDto) {
        OrderRequestDto orderRequestDto = saveRequestDto.getOrderRequestDto();
        ItemRequestDto itemRequestDto = saveRequestDto.getItemRequestDto();
        saveService.save(orderRequestDto);
        return "OK";
    }


}
