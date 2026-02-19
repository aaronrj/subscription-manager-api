package com.arodriguez.subscriptionmanager.service;

import com.arodriguez.subscriptionmanager.dto.SubscriptionRequest;
import com.arodriguez.subscriptionmanager.dto.SubscriptionResponse;
import com.arodriguez.subscriptionmanager.entity.Subscription;
import com.arodriguez.subscriptionmanager.exception.SubscriptionNotFoundException;
import com.arodriguez.subscriptionmanager.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository repository;

    public List<SubscriptionResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public SubscriptionResponse findById(Long id) {
        return toResponse(getEntityById(id));
    }

    public SubscriptionResponse create(SubscriptionRequest request) {
        Subscription s = new Subscription();
        s.setName(request.getName());
        s.setCategory(request.getCategory());
        s.setMonthlyCost(request.getMonthlyCost());
        s.setActive(request.getActive() == null ? true : request.getActive());

        return toResponse(repository.save(s));
    }

    public SubscriptionResponse update(Long id, SubscriptionRequest request) {
        Subscription existing = getEntityById(id);

        existing.setName(request.getName());
        existing.setCategory(request.getCategory());
        existing.setMonthlyCost(request.getMonthlyCost());

        // active opcional (si viene null, no lo tocamos)
        if (request.getActive() != null) {
            existing.setActive(request.getActive());
        }

        return toResponse(repository.save(existing));
    }

    public void deleteById(Long id) {
        Subscription existing = getEntityById(id);
        repository.delete(existing);
    }

    public BigDecimal getTotalMonthlyCost() {
        return repository.sumTotalMonthlyCost();
    }

    public BigDecimal getActiveMonthlyCost() {
        return repository.sumActiveMonthlyCost();
    }

    // ----------------- helpers -----------------
    private Subscription getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SubscriptionNotFoundException(id));
    }

    private SubscriptionResponse toResponse(Subscription s) {
        return new SubscriptionResponse(
                s.getId(),
                s.getName(),
                s.getMonthlyCost(),
                s.getCategory(),
                s.getActive()
        );
    }
}
