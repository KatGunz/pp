package project.boys.pp.DAO;

import project.boys.pp.Domain.FoodToBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodToBrandDAO extends JpaRepository<FoodToBrand,Long>{
}

