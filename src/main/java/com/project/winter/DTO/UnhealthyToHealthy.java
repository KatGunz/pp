package com.project.winter.DTO;

import com.project.winter.CompositeKeys.UnhealthyToHealthyCompositeKey;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(UnhealthyToHealthyCompositeKey.class)
@Table(name = "unhealthytohealthy")
public class UnhealthyToHealthy {

    @NotNull
    @EmbeddedId
    @Column(name = "unhealthyFoodID")
    private Long unhealthyFoodID;

    @NotNull
    @EmbeddedId
    @Column(name = "healthyFoodID")
    private Long healthyFoodID;

    public Long getUnhealthyFoodID() { return unhealthyFoodID;}

    public void setUnhealthyFoodID(long unhealthyFoodID) { this.unhealthyFoodID = unhealthyFoodID;}

    public Long getHealthyFoodID() { return healthyFoodID;}

    public void setHealthyFoodID(Long healthyFoodID) { this.healthyFoodID = healthyFoodID; }

}

