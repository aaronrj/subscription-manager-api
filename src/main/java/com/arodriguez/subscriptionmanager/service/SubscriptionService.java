package com.arodriguez.subscriptionmanager.service;

import com.arodriguez.subscriptionmanager.dto.SubscriptionRequest;
import com.arodriguez.subscriptionmanager.entity.Subscription;
import com.arodriguez.subscriptionmanager.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository repository;

    public List<Subscription> findAll() {
        return repository.findAll();
    }

    public Subscription findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    // ✅ NUEVO: create() para tu Controller nuevo
    public Subscription create(SubscriptionRequest request) {
        Subscription subscription = new Subscription();
        subscription.setName(request.getName());
        subscription.setCategory(request.getCategory());
        subscription.setMonthlyCost(request.getMonthlyCost());

        // default true si no viene
        subscription.setActive(request.getActive() == null ? true : request.getActive());

        return repository.save(subscription);
    }

    // ✅ NUEVO: update() con DTO para tu Controller nuevo
    public Subscription update(Long id, SubscriptionRequest request) {
        Subscription existing = findById(id);

        existing.setName(request.getName());
        existing.setCategory(request.getCategory());
        existing.setMonthlyCost(request.getMonthlyCost());

        // Si quieres que active sea opcional en update:
        if (request.getActive() != null) {
            existing.setActive(request.getActive());
        }

        return repository.save(existing);
    }

    public void deleteById(Long id) {
        Subscription existing = findById(id);
        repository.delete(existing);
    }

    public Double getTotalMonthlyCost() {
        return repository.sumTotalMonthlyCost();
    }

    public Double getActiveMonthlyCost() {
        return repository.sumActiveMonthlyCost();
    }
}
