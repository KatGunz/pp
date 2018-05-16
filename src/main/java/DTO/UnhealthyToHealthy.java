package DTO;

import CompositeKeys.UnhealthyToHealthyCompositeKey;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UnhealthyToHealthyCompositeKey.class)
@Table(name = "unhealthytohealthy")
public class UnhealthyToHealthy {
    @Column(name = "unhealthyFoodID")
    @Id
    private Long unhealthyFoodID;
    @Column(name = "healthyFoodID")
    @Id
    private Long healthyFoodID;

    public Long getUnhealthyFoodID() { return unhealthyFoodID;}

    public void setUnhealthyFoodID(long unhealthyFoodID) { this.unhealthyFoodID = unhealthyFoodID;}

    public Long getHealthyFoodID() { return healthyFoodID;}

    public void setHealthyFoodID(Long healthyFoodID) { this.healthyFoodID = healthyFoodID; }

}

