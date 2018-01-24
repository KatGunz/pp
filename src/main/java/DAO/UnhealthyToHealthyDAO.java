package DAO;

import Beans.UnhealthyToHealthy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UnhealthyToHealthyDAO extends JpaRepository<Beans.UnhealthyToHealthy,Long>{
    List<UnhealthyToHealthy> findByUnhealthyFoodId(Long unhealthyFoodId);
}
