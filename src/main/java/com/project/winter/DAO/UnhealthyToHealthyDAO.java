package com.project.winter.DAO;

import com.project.winter.DTO.UnhealthyToHealthy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UnhealthyToHealthyDAO extends JpaRepository<com.project.winter.DTO.UnhealthyToHealthy,Long>{
    List<UnhealthyToHealthy> getAllByUnhealthyId(Long unhealthyId);
}
