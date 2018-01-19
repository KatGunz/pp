package Beans;

@Entity
@Table(name = "brand")
public class Brand {
    @Column(name = "brandID")
    private long brandID;
    @Column(name = "brandName")
    private String brandName;
    
    public long getBrandID() {
        return brandID;
    }

    public void setBrandID(long brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
