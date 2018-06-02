package project.boys.pp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Brand {

    @Column(name = "Brand_Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private long brandId;

    @Column(name = "Brand_Name")
    @NotBlank
    private String brandName;
    
    public long getBrandID() {
        return brandId;
    }

    public void setBrandID(long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
