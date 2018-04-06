package DAO;

import DTO.UnhealthyToHealthy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UnhealthyToHealthyDAO extends JpaRepository<DTO.UnhealthyToHealthy,Long>{
    List<UnhealthyToHealthy> getAllByUnhealthyId(Long unhealthyId);
}
