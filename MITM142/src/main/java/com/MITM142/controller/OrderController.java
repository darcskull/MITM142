package com.MITM142.controller;

import com.MITM142.data.Order;
import com.MITM142.data.Service;
import com.MITM142.data.User;
import com.MITM142.service.OrderService;
import com.MITM142.service.ServiceService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ServiceService service;

    @GetMapping("/orders")
    public String getOrders(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        var orders = orderService.getPersonalOrderList(user.getId());
        model.addAttribute("personalOrders", orders);
        return "personalOrders";
    }

    @GetMapping("/orders/form")
    public String getOrderForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        model.addAttribute("listOfServices", service.getServiceList(user.getId()));
        return "orderForm";
    }

    @GetMapping("/orders/service")
    public String getPersonalServiceOrders(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        var orders = orderService.getPersonalServiceOrderList(user.getId());
        model.addAttribute("personalServiceOrders", orders);
        return "serviceOrders";
    }

    @PostMapping("/create/order")
    public ResponseEntity<Void> createOrder(HttpSession session, @RequestBody Map<String, String> request) {
        User user = (User) session.getAttribute("loggedInUser");
        var orderData = new Order();
        orderData.setBuyerId(user.getId());
        orderData.setServiceId(Integer.valueOf(request.get("serviceId")));
        orderData.setAddress(request.get("address"));
        orderService.saveOrder(orderData);
        return ResponseEntity.ok().build();
    }

}
