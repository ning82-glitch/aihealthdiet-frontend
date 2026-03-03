package com.aihealth.backend.repository;

import com.aihealth.backend.entity.FoodLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodLogRepository extends JpaRepository<FoodLog, Long> {
    List<FoodLog> findByUserId(Long userId);
}
