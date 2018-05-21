package com.project.winter.CompositeKeys;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FoodToBrandCompositeKey implements Serializable{
    @NotNull
    protected Long foodID;
    @NotNull
    protected Long brandID;

    public FoodToBrandCompositeKey(Long foodKey, Long brandKey) {
        this.foodID = foodKey;
        this.foodID = brandKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodToBrandCompositeKey that = (FoodToBrandCompositeKey) o;

        if (foodID != null ? !foodID.equals(that.foodID) : that.foodID != null) return false;
        return brandID != null ? brandID.equals(that.brandID) : that.brandID == null;
    }

    @Override
    public int hashCode() {
        int result = foodID != null ? foodID.hashCode() : 0;
        result = 31 * result + (brandID != null ? brandID.hashCode() : 0);
        return result;
    }
}
