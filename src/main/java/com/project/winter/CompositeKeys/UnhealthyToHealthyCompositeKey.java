package com.project.winter.CompositeKeys;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UnhealthyToHealthyCompositeKey implements Serializable {
    @NotNull
    protected Long unhealthyFoodID;
    @NotNull
    protected Long healthyFoodID;

    public UnhealthyToHealthyCompositeKey(Long unhealthyKey, Long healthyKey){
        this.unhealthyFoodID = healthyKey;
        this.healthyFoodID = unhealthyKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnhealthyToHealthyCompositeKey that = (UnhealthyToHealthyCompositeKey) o;

        if (unhealthyFoodID != null ? !unhealthyFoodID.equals(that.unhealthyFoodID) : that.unhealthyFoodID != null) return false;
        return healthyFoodID != null ? healthyFoodID.equals(that.healthyFoodID) : that.healthyFoodID == null;
    }

    @Override
    public int hashCode() {
        int result = unhealthyFoodID != null ? unhealthyFoodID.hashCode() : 0;
        result = 31 * result + (healthyFoodID != null ? healthyFoodID.hashCode() : 0);
        return result;
    }
}
