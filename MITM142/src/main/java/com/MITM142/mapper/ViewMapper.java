package com.MITM142.mapper;

import com.MITM142.data.*;

import java.util.List;

public class ViewMapper {

    public static List<ServiceView> mapToServiceView(List<Service> services, List<User> users) {
        return services.stream().map(service -> {
            var view = new ServiceView();
            view.setServiceId(service.getId());
            view.setPrice(service.getPrice());
            view.setType(service.getType());
            view.setLongDescription(service.getLongDescription());
            view.setShortDescription(service.getShortDescription());
            view.setTimeInHours(service.getTimeInHours());

            var user = users.stream()
                    .filter(u -> u.getId().equals(service.getUserId()))
                    .findFirst().orElseThrow();

            view.setEmail(user.getEmail());
            view.setPhoneNumber(user.getPhoneNumber());
            view.setFirstName(user.getFirstName());
            view.setLastName(user.getLastName());
            view.setUserId(user.getId());

            return view;
        }).toList();
    }

    public static List<OrderView> mapToOrderView(List<Order> orders, List<Service> services, List<User> users) {
        return orders.stream().map(order -> {
            var user = users.stream()
                    .filter(u -> u.getId().equals(order.getBuyerId()))
                    .findFirst()
                    .orElseThrow();

            var service = services.stream()
                    .filter(s -> s.getId().equals(order.getServiceId()))
                    .findFirst()
                    .orElseThrow();

            var view = new OrderView();
            view.setId(order.getId());
            view.setServiceId(service.getId());
            view.setPrice(service.getPrice());
            view.setType(service.getType());
            view.setLongDescription(service.getLongDescription());
            view.setShortDescription(service.getShortDescription());
            view.setTimeInHours(service.getTimeInHours());
            view.setOwnerId(service.getUserId());
            view.setEmail(user.getEmail());
            view.setPhoneNumber(user.getPhoneNumber());
            view.setFirstName(user.getFirstName());
            view.setLastName(user.getLastName());
            view.setBuyerId(user.getId());
            view.setAddress(order.getAddress());

            return view;
        }).toList();
    }

}
