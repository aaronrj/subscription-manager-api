package com.arodriguez.subscriptionmanager.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull(message = "Monthly cost is required")
    @Positive(message = "Monthly cost must be greater than 0")
    private Double monthlyCost;


    private String category;

    private Boolean active;

}
