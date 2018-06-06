package project.boys.pp.Domain;

import project.boys.pp.CompositeKeys.FoodToBrandCompositeKey;

import javax.persistence.*;

@Entity
@IdClass(FoodToBrandCompositeKey.class)
@Table(name = "foodtobrand")
public class FoodToBrand {

    @Column(name = "Food_Id")
    @Id
    private long foodId;

    @Column(name = "Brand_Id")
    @Id
    private long brandId;

    public long getFoodId() { return foodId;}

    public void setFoodId(long foodId) {this.foodId = foodId;}

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }
}
