package DAO;

import Beans.FoodToBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodToBrandDAO extends JpaRepository<FoodToBrand,Long>{
    List<FoodToBrand> findByFoodId(Long foodId);
    List<FoodToBrand> findByBrandId(Long brandId);
}

