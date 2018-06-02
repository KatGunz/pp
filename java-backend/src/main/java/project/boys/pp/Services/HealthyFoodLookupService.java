package project.boys.pp.Services;

import project.boys.pp.DAO.FoodDAO;
import project.boys.pp.DAO.UnhealthyToHealthyDAO;
import project.boys.pp.DTO.Food;
import project.boys.pp.DTO.UnhealthyToHealthy;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;


@Service
@Transactional
public class HealthyFoodLookupService {

    @Inject
    private FoodDAO foodDAO;

    @Inject
    private UnhealthyToHealthyDAO uthDAO;

    private final static Logger logger = Logger.getLogger(HealthyFoodLookupService.class);

    public ArrayList<String> findHealthyFoodsNameByUnhealthyFoodName(String unhealthyFood){
        logger.info("Finding healthy foods for unhealthy food name: "+ unhealthyFood );
        List<Food> foodResultSet = foodDAO.findByFoodName(unhealthyFood);
        //if the food is unknown, return null
        if(isEmpty(foodResultSet)){
            return null;
        }
        Food result = foodResultSet.get(0);
        Long foodId = result.getFoodId();
        List<UnhealthyToHealthy> junctionResultList = uthDAO.getAllByUnhealthyFoodId(foodId);
        ArrayList<String> allHealthyMatchesNames = new ArrayList<>();
        //if no suggestions are found, return the empty arraylist
        if(isEmpty(junctionResultList)){
            return allHealthyMatchesNames;
        }
        ArrayList<Long> idList = new ArrayList<>();
        for(UnhealthyToHealthy uth: junctionResultList) {
            idList.add(uth.getHealthyFoodId());
        }
        List<Food> allHealthyMatches = foodDAO.findAll(idList);
        allHealthyMatchesNames = new ArrayList<>();
        for(Food healthyMatch: allHealthyMatches){
            allHealthyMatchesNames.add(healthyMatch.getFoodName());
        }
        //return the populated suggestions
        return allHealthyMatchesNames;

    }

}
