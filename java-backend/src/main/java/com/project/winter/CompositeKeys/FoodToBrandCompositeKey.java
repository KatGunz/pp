package com.project.winter.CompositeKeys;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FoodToBrandCompositeKey implements Serializable{
    @NotNull
    protected Long foodId;
    @NotNull
    protected Long brandId;

    public FoodToBrandCompositeKey(){
    }
    public FoodToBrandCompositeKey(Long foodId, Long brandId) {
        this.foodId = foodId;
        this.foodId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodToBrandCompositeKey that = (FoodToBrandCompositeKey) o;

        if (foodId != null ? !foodId.equals(that.foodId) : that.foodId != null) return false;
        return brandId != null ? brandId.equals(that.brandId) : that.brandId == null;
    }

    @Override
    public int hashCode() {
        int result = foodId != null ? foodId.hashCode() : 0;
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        return result;
    }
}
