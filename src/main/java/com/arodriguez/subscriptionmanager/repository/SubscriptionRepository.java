package com.arodriguez.subscriptionmanager.repository;

import com.arodriguez.subscriptionmanager.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("select coalesce(sum(s.monthlyCost), 0) from Subscription s")
    BigDecimal sumTotalMonthlyCost();

    @Query("select coalesce(sum(s.monthlyCost), 0) from Subscription s where s.active = true")
    BigDecimal sumActiveMonthlyCost();
}
