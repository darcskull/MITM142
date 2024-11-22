package com.MITM142.repository;

import com.MITM142.data.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> findAllOrders() {
        String query = "SELECT * FROM \"ORDER\"";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        List<Order> orders = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            orders.add(mapRowToOrder(row));
        }

        return orders;
    }

    public Order findOrderById(Integer id) {
        String query = "SELECT * FROM \"ORDER\" WHERE id = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, id);

        return getOrder(rows);
    }

    public List<Order> findOrdersByBuyerId(Integer buyerId) {
        String query = "SELECT * FROM \"ORDER\" WHERE buyerId = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, buyerId);
        List<Order> orders = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            orders.add(mapRowToOrder(row));
        }

        return orders;
    }

    public List<Order> findOrdersByServiceId(Integer serviceId) {
        String query = "SELECT * FROM \"ORDER\" WHERE serviceId = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, serviceId);
        List<Order> orders = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            orders.add(mapRowToOrder(row));
        }

        return orders;
    }

    public void createOrder(Order order) {
        String query = "INSERT INTO \"ORDER\" (id, serviceId, buyerId, address) " +
                "VALUES (nextval('order_sequence'), ?, ?, ?)";
        jdbcTemplate.update(query,
                order.getServiceId(),
                order.getBuyerId(),
                order.getAddress());
    }

    public void updateOrder(Order order) {
        String query = "UPDATE \"ORDER\" SET serviceId = ?, buyerId = ?, address = ? WHERE id = ?";
        jdbcTemplate.update(query,
                order.getServiceId(),
                order.getBuyerId(),
                order.getAddress(),
                order.getId());
    }

    public void deleteOrderById(Integer id) {
        String query = "DELETE FROM \"ORDER\" WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    private Order getOrder(List<Map<String, Object>> rows) {
        if (rows.isEmpty()) {
            return null;
        }
        return mapRowToOrder(rows.get(0));
    }

    private Order mapRowToOrder(Map<String, Object> row) {
        Order order = new Order();
        order.setId((Integer) row.get("id"));
        order.setServiceId((Integer) row.get("serviceId"));
        order.setBuyerId((Integer) row.get("buyerId"));
        order.setAddress((String) row.get("address"));
        return order;
    }
}
