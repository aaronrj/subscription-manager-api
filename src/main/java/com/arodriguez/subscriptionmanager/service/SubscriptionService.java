package com.arodriguez.subscriptionmanager.service;

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

    public Subscription save(Subscription subscription) {

        if (subscription.getActive() == null) {
            subscription.setActive(true);
        }

        return repository.save(subscription);
    }

    public Subscription update(Long id, Subscription update) {

        Subscription existing = findById(id);

        existing.setName(update.getName());
        existing.setCategory(update.getCategory());
        existing.setMonthlyCost(update.getMonthlyCost());
        existing.setActive(update.getActive());

        return repository.save(existing);
    }

    public void deleteById(Long id) {

        Subscription existing = findById(id);
        repository.delete(existing);
    }
}
