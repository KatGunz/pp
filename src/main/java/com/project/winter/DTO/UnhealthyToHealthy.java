package com.project.winter.DTO;

import com.project.winter.CompositeKeys.UnhealthyToHealthyCompositeKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(UnhealthyToHealthyCompositeKey.class)
@Table(name = "unhealthytohealthy")
public class UnhealthyToHealthy {

    @NotNull
    @Id
    @Column(name = "Unhealthy_Food_Id")
    private Long unhealthyFoodId;

    @NotNull
    @Id
    @Column(name = "Healthy_Food_Id")
    private Long healthyFoodId;

    public Long getUnhealthyFoodId() { return unhealthyFoodId;}

    public void setUnhealthyFoodId(long unhealthyFoodId) { this.unhealthyFoodId = unhealthyFoodId;}

    public Long getHealthyFoodId() { return healthyFoodId;}

    public void setHealthyFoodId(Long healthyFoodId) { this.healthyFoodId = healthyFoodId; }

}

