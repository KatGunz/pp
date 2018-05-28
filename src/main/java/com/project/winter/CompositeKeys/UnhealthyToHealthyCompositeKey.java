package com.project.winter.CompositeKeys;

import com.project.winter.DTO.UnhealthyToHealthy;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UnhealthyToHealthyCompositeKey implements Serializable {
    @NotNull
    protected Long unhealthyFoodId;
    @NotNull
    protected Long healthyFoodId;

    public UnhealthyToHealthyCompositeKey(){
    }
    public UnhealthyToHealthyCompositeKey(Long unhealthyFoodId, Long healthyFoodId){
        this.unhealthyFoodId = unhealthyFoodId;
        this.healthyFoodId = healthyFoodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnhealthyToHealthyCompositeKey that = (UnhealthyToHealthyCompositeKey) o;

        if (unhealthyFoodId != null ? !unhealthyFoodId.equals(that.unhealthyFoodId) : that.unhealthyFoodId != null) return false;
        return healthyFoodId != null ? healthyFoodId.equals(that.healthyFoodId) : that.healthyFoodId == null;
    }

    @Override
    public int hashCode() {
        int result = unhealthyFoodId != null ? unhealthyFoodId.hashCode() : 0;
        result = 31 * result + (healthyFoodId != null ? healthyFoodId.hashCode() : 0);
        return result;
    }
}
