package com.arodriguez.subscriptionmanager.controller;

import com.arodriguez.subscriptionmanager.entity.Subscription;
import com.arodriguez.subscriptionmanager.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService service;

    @PostMapping
    public Subscription create(@RequestBody Subscription subscription){
        return service.save(subscription);
    }

    @GetMapping
    public List<Subscription> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Subscription getById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Subscription update(@PathVariable Long id, @RequestBody Subscription update){
        return service.update(id, update);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

    @GetMapping("/stats/total-monthly")
    public Double getTotalMonthlyCost() {
        return service.findAll()
                .stream()
                .mapToDouble(s -> s.getMonthlyCost() == null ? 0.0 : s.getMonthlyCost())
                .sum();
    }

    @GetMapping("/stats/active-monthly")
    public Double getActiveMonthlyCost() {
        return service.findAll()
                .stream()
                .filter(s -> Boolean.TRUE.equals(s.getActive()))
                .mapToDouble(s -> s.getMonthlyCost() == null ? 0.0 : s.getMonthlyCost())
                .sum();
    }
}
