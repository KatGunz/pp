package com.project.winter.DAO;

import com.project.winter.DTO.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodDAO extends JpaRepository<Food,Long>{
    List<Food> findByFoodId(Long foodId);
    List<Food> findByFoodName(String foodName);
}

