package line.pay.cafe.controller;

import line.pay.cafe.domain.Item;
import line.pay.cafe.service.FindService;
import lombok.RequiredArgsConstructor;
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

    // GET /api/pay/{id}
    @GetMapping("/item/{id}")
    public Optional<Item> getPayById(@PathVariable Long id) {
        return findService.findItemById(id);
    }

    // GET /api/pay/all
    @GetMapping("/item/all")
    public List<Item> getAllPays() {
        return findService.findItemAll();
    }

}
