package com.arodriguez.subscriptionmanager.controller;

import com.arodriguez.subscriptionmanager.dto.SubscriptionRequest;
import com.arodriguez.subscriptionmanager.dto.SubscriptionResponse;
import com.arodriguez.subscriptionmanager.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService service;

    @PostMapping
    public ResponseEntity<SubscriptionResponse> create(@Valid @RequestBody SubscriptionRequest request) {
        SubscriptionResponse created = service.create(request);
        return ResponseEntity
                .created(URI.create("/subscriptions/" + created.getId()))
                .body(created);
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody SubscriptionRequest request
    ) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stats/total-monthly")
    public ResponseEntity<BigDecimal> getTotalMonthlyCost() {
        return ResponseEntity.ok(service.getTotalMonthlyCost());
    }

    @GetMapping("/stats/active-monthly")
    public ResponseEntity<BigDecimal> getActiveMonthlyCost() {
        return ResponseEntity.ok(service.getActiveMonthlyCost());
    }
}
