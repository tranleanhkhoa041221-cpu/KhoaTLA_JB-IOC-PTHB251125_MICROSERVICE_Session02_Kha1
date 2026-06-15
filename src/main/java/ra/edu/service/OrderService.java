package ra.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.dto.OrderDTO;
import ra.edu.entity.Order;
import ra.edu.exception.ResourceNotFoundException;
import ra.edu.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order với ID " + id + " không tồn tại trên hệ thống!"));

        return new OrderDTO(order.getId(), order.getProductName(), order.getQuantity());
    }

}
