package project.boys.pp.DAO;

import project.boys.pp.Domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDAO extends JpaRepository<Brand,Long>{
}
