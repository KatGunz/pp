package DAO;

import DTO.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodDAO extends JpaRepository<Food,Long>{
    List<Food> findById(Long Id);
    List<Food> findByFood(Food food);
}
