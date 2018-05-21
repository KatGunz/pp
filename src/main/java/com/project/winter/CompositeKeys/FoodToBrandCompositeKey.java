package com.project.winter.CompositeKeys;

import java.io.Serializable;

public class FoodToBrandCompositeKey implements Serializable{
    protected Long foodKey;
    protected Long brandKey;
    public FoodToBrandCompositeKey(Long foodKey, Long brandKey) {
        this.foodKey = foodKey;
        this.brandKey = brandKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodToBrandCompositeKey that = (FoodToBrandCompositeKey) o;

        if (foodKey != null ? !foodKey.equals(that.foodKey) : that.foodKey != null) return false;
        return brandKey != null ? brandKey.equals(that.brandKey) : that.brandKey == null;
    }

    @Override
    public int hashCode() {
        int result = foodKey != null ? foodKey.hashCode() : 0;
        result = 31 * result + (brandKey != null ? brandKey.hashCode() : 0);
        return result;
    }
}
