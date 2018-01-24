package DAO;

import Beans.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDAO extends JpaRepository<Brand,Long>{
        List<Brand> findById(Long Id);
        List<Brand> findByBrand(Brand brand);
}
