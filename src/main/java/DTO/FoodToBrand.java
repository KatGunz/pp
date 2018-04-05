package DTO;

import CompositeKeys.FTBCompositeKey;

import javax.persistence.*;

@Entity
@IdClass(FTBCompositeKey.class)
@Table(name = "foodtobrand")
public class FoodToBrand {

    @Column(name = "foodID")
    @Id
    private long foodID;

    @Column(name = "brandID")
    @Id
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