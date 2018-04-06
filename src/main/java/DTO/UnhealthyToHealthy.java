package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unhealthytohealthy")
public class UnhealthyToHealthy {
    @Column(name = "unhealthyFoodID")
    private Long unhealthyFoodID;
    @Column(name = "healthyFoodID")
    private Long healthyFoodID;

    public Long getUnhealthyFoodID() { return unhealthyFoodID;}

    public void setUnhealthyFoodID(long unhealthyFoodID) { this.unhealthyFoodID = unhealthyFoodID;}

    public Long getHealthyFoodID() { return healthyFoodID;}

    public void setHealthyFoodID(Long healthyFoodID) { this.healthyFoodID = healthyFoodID; }

}

