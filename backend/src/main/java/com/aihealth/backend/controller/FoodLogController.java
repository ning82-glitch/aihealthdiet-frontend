package com.aihealth.backend.controller;

import com.aihealth.backend.entity.FoodLog;
import com.aihealth.backend.repository.FoodLogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodlog")
public class FoodLogController {
    private final FoodLogRepository repo;

    public FoodLogController(FoodLogRepository repo) { this.repo = repo; }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody FoodLog log) {
        try {
            FoodLog saved = repo.save(log);
            return ResponseEntity.ok(saved);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body(java.util.Map.of("error", ex.getMessage()));
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FoodLog>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(repo.findByUserId(userId));
    }
}
