package com.arodriguez.subscriptionmanager.dto;

import java.math.BigDecimal;

public class SubscriptionResponse {
    private Long id;
    private String name;
    private BigDecimal monthlyCost;
    private String category;
    private Boolean active;

    public SubscriptionResponse() {}

    public SubscriptionResponse(Long id, String name, BigDecimal monthlyCost, String category, Boolean active) {
        this.id = id;
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.category = category;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getMonthlyCost() { return monthlyCost; }
    public void setMonthlyCost(BigDecimal monthlyCost) { this.monthlyCost = monthlyCost; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
