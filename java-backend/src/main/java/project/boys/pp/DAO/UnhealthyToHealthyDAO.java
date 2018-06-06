package project.boys.pp.DAO;

import project.boys.pp.Domain.UnhealthyToHealthy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UnhealthyToHealthyDAO extends JpaRepository<UnhealthyToHealthy,Long>{
    List<UnhealthyToHealthy> getAllByUnhealthyFoodId(Long unhealthyFoodId);
}
