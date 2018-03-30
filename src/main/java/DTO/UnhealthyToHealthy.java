package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unhealthytohealthy")
public class UnhealthyToHealthy {
    @Column(name = "unhealthyFoodID")
    private long unhealthyFoodID;
    @Column(name = "healthyFoodID")
    private String healthyFoodID;

    public long getUnhealthyFoodID() { return unhealthyFoodID;}

    public void setUnhealthyFoodID(long unhealthyFoodID) { this.unhealthyFoodID = unhealthyFoodID;}

    public String getHealthyFoodID() { return healthyFoodID;}

    public void setHealthyFoodID(String healthyFoodID) { this.healthyFoodID = healthyFoodID; }

}

