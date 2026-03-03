package com.aihealth.backend.controller;

import com.aihealth.backend.entity.Goal;
import com.aihealth.backend.repository.GoalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class GoalController {
    private final GoalRepository repo;

    public GoalController(GoalRepository repo) { this.repo = repo; }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Goal goal) {
        return ResponseEntity.ok(repo.save(goal));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Goal>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(repo.findByUserId(userId));
    }
}
