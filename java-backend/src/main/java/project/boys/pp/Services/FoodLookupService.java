package project.boys.pp.Services;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import project.boys.pp.DAO.FoodDAO;
import project.boys.pp.DAO.UnhealthyToHealthyDAO;
import project.boys.pp.DTO.FoodDTO;
import project.boys.pp.Domain.Food;
import project.boys.pp.Domain.UnhealthyToHealthy;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;


@Service
@Transactional
public class FoodLookupService {
    @Inject
    private FoodDAO foodDAO;

    @Inject
    private UnhealthyToHealthyDAO uthDAO;

    private final static Logger logger = Logger.getLogger(FoodLookupService.class);

    public ArrayList<FoodDTO> findHealthyFoodsNameByUnhealthyFoodName(String unhealthyFood){
        logger.info("Finding healthy foods for unhealthy food name: "+ unhealthyFood );
        List<Food> foodResultSet = foodDAO.findByFoodName(unhealthyFood);
        //if the food is unknown, return null
        if(isEmpty(foodResultSet)){
            return null;
        }
        Food result = foodResultSet.get(0);
        Long foodId = result.getFoodId();
        List<UnhealthyToHealthy> junctionResultList = uthDAO.getAllByUnhealthyFoodId(foodId);
        ArrayList<FoodDTO> allHealthyMatchesNames = new ArrayList<>();
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
            FoodDTO foodDTO = convertFoodDomainToDTO(healthyMatch);
            allHealthyMatchesNames.add(foodDTO);
        }
        //return the populated suggestions
        return allHealthyMatchesNames;
    }

    public List<FoodDTO> findKnownFoods() {
        logger.info("Finding known foods ");
        List<FoodDTO> foodDTOList = new ArrayList<>();
        List<Food> foodResultSet = foodDAO.findAll();
        for(Food healthyMatch: foodResultSet){
            FoodDTO foodDTO = convertFoodDomainToDTO(healthyMatch);
            foodDTOList.add(foodDTO);
        }
        return foodDTOList;
    }

    private FoodDTO convertFoodDomainToDTO(Food food){
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setFoodName(food.getFoodName());
        return foodDTO;
    }
}