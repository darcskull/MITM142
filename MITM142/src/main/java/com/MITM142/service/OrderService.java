package com.MITM142.service;

import com.MITM142.data.Order;
import com.MITM142.data.OrderView;
import com.MITM142.exception.BadRequestException;
import com.MITM142.exception.GeneralException;
import com.MITM142.repository.OrderRepository;
import com.MITM142.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.MITM142.mapper.ViewMapper.mapToOrderView;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ServiceService service;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    // Get user orders
    public List<OrderView> getPersonalOrderList(Integer userId){
        return mapToOrderView(orderRepository.findOrdersByBuyerId(userId),
                service.getServices(userId), userRepository.findAllUsers());
    }

    // Get user orders made for his services
    public List<OrderView> getPersonalServiceOrderList(Integer userId){
        var services = service.getPersonalServiceList(userId);
        List<Order> orders = new ArrayList<>();
        for(com.MITM142.data.Service service: services){
            orders.addAll(orderRepository.findOrdersByServiceId(service.getId()));
        }
        return mapToOrderView(orders, services, userRepository.findAllUsers());
    }

    public void saveOrder(Order order) {
        if (Objects.equals(order.getAddress(), "") || order.getServiceId() == null || order.getBuyerId() == null) {
            throw new BadRequestException("Empty values are not allowed");
        }
        try {
            orderRepository.createOrder(order);
        } catch (Exception exception) {
            throw new GeneralException("An error has occurred, the provided data was not registered");
        }

    }
}
