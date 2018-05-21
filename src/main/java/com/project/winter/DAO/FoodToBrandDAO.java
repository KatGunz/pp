package com.project.winter.DAO;

import com.project.winter.DTO.FoodToBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodToBrandDAO extends JpaRepository<FoodToBrand,Long>{
}

