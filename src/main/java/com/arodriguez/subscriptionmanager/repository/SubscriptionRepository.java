package com.arodriguez.subscriptionmanager.repository;

import com.arodriguez.subscriptionmanager.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
}
