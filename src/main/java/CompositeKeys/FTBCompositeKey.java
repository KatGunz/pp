package CompositeKeys;

import java.io.Serializable;
import java.util.Objects;

public class FTBCompositeKey implements Serializable{
    protected Long foodKey;
    protected Long brandKey;
    public FTBCompositeKey(Long foodKey, Long brandKey) {
        this.foodKey = foodKey;
        this.brandKey = brandKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FTBCompositeKey that = (FTBCompositeKey) o;
        return Objects.equals(foodKey, that.foodKey) &&
                Objects.equals(brandKey, that.brandKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodKey, brandKey);
    }
}
