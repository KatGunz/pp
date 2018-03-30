package DAO;

import DTO.FoodToBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodToBrandDAO extends JpaRepository<FoodToBrand,Long>{
}

