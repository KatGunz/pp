package Beans;

@Entity
@Table(name = "foodtobrand")
public class FoodToBrand {
    @Column(name = "foodID")
    private long foodID;
    @Column(name = "brandID")
    private String brandID;

    public long getFoodID() { return foodID;}

    public void setFoodID(long foodID) {this.foodID = foodID;}

    public long getBrandID() {
        return brandID;
    }

    public void setBrandID(long brandID) {
        this.brandID = brandID;
    }
}
