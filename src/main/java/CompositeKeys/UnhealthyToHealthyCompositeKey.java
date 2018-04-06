package CompositeKeys;

import java.io.Serializable;

public class UnhealthyToHealthyCompositeKey implements Serializable {
    protected Long unhealthyKey;
    protected Long healthyKey;

    public UnhealthyToHealthyCompositeKey(Long unhealthyKey, Long healthyKey){
        this.healthyKey = healthyKey;
        this.unhealthyKey = unhealthyKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnhealthyToHealthyCompositeKey that = (UnhealthyToHealthyCompositeKey) o;

        if (unhealthyKey != null ? !unhealthyKey.equals(that.unhealthyKey) : that.unhealthyKey != null) return false;
        return healthyKey != null ? healthyKey.equals(that.healthyKey) : that.healthyKey == null;
    }

    @Override
    public int hashCode() {
        int result = unhealthyKey != null ? unhealthyKey.hashCode() : 0;
        result = 31 * result + (healthyKey != null ? healthyKey.hashCode() : 0);
        return result;
    }
}
