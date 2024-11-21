package com.MITM142.repository;

import com.MITM142.data.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
    List<Service> findByUserId(Integer userId);
    List<Service> findByType(String type);
}
