package ra.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.edu.dto.OrderDTO;
import ra.edu.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/health-check")
    public String healthCheck() {
        return "Order Service is Up";
    }

    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }


}
