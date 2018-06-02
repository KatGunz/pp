package project.boys.pp.DAO;

import project.boys.pp.DTO.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodDAO extends JpaRepository<Food,Long>{
    List<Food> findByFoodId(Long foodId);
    List<Food> findByFoodName(String foodName);
}

