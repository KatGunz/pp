package com.project.winter.DAO;

import com.project.winter.DTO.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDAO extends JpaRepository<Brand,Long>{
}
