package com.MITM142.repository;

import com.MITM142.data.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ServiceRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Service> findAllServices() {
        String query = "SELECT * FROM \"SERVICE\"";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        List<Service> services = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            Service service = mapRowToService(row);
            services.add(service);
        }

        return services;
    }

    public Service findServiceById(Integer id) {
        String query = "SELECT * FROM \"SERVICE\" WHERE id = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, id);

        return getService(rows);
    }

    public List<Service> findServicesByUserId(Integer userId) {
        String query = "SELECT * FROM \"SERVICE\" WHERE userId = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, userId);
        List<Service> services = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            services.add(mapRowToService(row));
        }

        return services;
    }

    public void createService(Service service) {
        String query = "INSERT INTO \"SERVICE\" (id, shortDescription, longDescription, type, userId, price, timeInHours) " +
                "VALUES (nextval('service_sequence'), ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                service.getShortDescription(),
                service.getLongDescription(),
                service.getType(),
                service.getUserId(),
                service.getPrice(),
                service.getTimeInHours());
    }

    private Service getService(List<Map<String, Object>> rows) {
        if (rows.isEmpty()) {
            return null;
        }
        return mapRowToService(rows.get(0));
    }

    private Service mapRowToService(Map<String, Object> row) {

        return Service.builder()
                .id((Integer) row.get("id"))
                .shortDescription((String) row.get("shortDescription"))
                .longDescription((String) row.get("longDescription"))
                .type((String) row.get("type"))
                .userId((Integer) row.get("userId"))
                .price((BigDecimal) row.get("price"))
                .timeInHours((String) row.get("timeInHours"))
                .build();
    }
}
