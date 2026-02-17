package com.arodriguez.subscriptionmanager.repository;

import com.arodriguez.subscriptionmanager.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("select coalesce(sum(s.monthlyCost), 0) from Subscription s")
    Double sumTotalMonthlyCost();

    @Query("select coalesce(sum(s.monthlyCost), 0) from Subscription s where s.active = true")
    Double sumActiveMonthlyCost();
}
