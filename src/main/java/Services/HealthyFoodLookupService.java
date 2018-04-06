package Services;

import DAO.FoodDAO;
import DAO.UnhealthyToHealthyDAO;
import DTO.Food;
import DTO.UnhealthyToHealthy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class HealthyFoodLookupService {
    @Autowired
    private FoodDAO foodDAO;
    @Autowired
    private UnhealthyToHealthyDAO uthDAO;

    public ArrayList<String> findHealthyFoodsNameByUnhealthyFoodName(String unhealthyFood)throws NonUniqueResultException {
        List<Food> foodResultSet = foodDAO.findByFoodName(unhealthyFood);
        if(foodResultSet.size()==1){
            Food result = foodResultSet.get(0);
            Long foodId = result.getFoodID();
            UnhealthyToHealthy temp;
            List<UnhealthyToHealthy> junctionResultList = uthDAO.findAll();
            junctionResultList = junctionResultList.stream()
                    .filter(line -> (foodId==line.getUnhealthyFoodID()))
                    .collect(Collectors.toList());
            ArrayList<Long> idList = new ArrayList<>();
            for(int i=0; i<junctionResultList.size(); i++) {
                idList.add(junctionResultList.get(i).getHealthyFoodID());
            }
            List<Food> allHealthyMatches = foodDAO.findAll(idList);
            ArrayList<String> allHealthyMatchesNames = new ArrayList<>();
            for(int i=0; i<allHealthyMatches.size(); i++){
                allHealthyMatchesNames.add(allHealthyMatches.get(i).getFoodName());
            }
            return allHealthyMatchesNames;
        }else {
            throw new NonUniqueResultException("A non unique result was found.");
        }

    }

}
