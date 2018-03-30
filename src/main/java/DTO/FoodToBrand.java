package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "foodtobrand")
public class FoodToBrand {
    @Column(name = "foodID")
    private long foodID;
    @Column(name = "brandID")
    private long brandID;

    public long getFoodID() { return foodID;}

    public void setFoodID(long foodID) {this.foodID = foodID;}

    public long getBrandID() {
        return brandID;
    }

    public void setBrandID(long brandID) {
        this.brandID = brandID;
    }
}
