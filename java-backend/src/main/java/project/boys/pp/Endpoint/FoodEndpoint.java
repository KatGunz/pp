package project.boys.pp.Endpoint;

import project.boys.pp.Services.FoodLookupService;
import project.boys.pp.DTO.Food;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/foodLookup")
public class FoodEndpoint {

    @Inject
    private FoodLookupService foodLookupService;

    final static Logger logger = Logger.getLogger(FoodEndpoint.class);

    @ApiOperation(value = "suggests healthy food given unhealthy food")
    @RequestMapping(value = "/{unhealthyFoodName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> findHealthyFoodNameByUnhealthyFoodName(@PathVariable String unhealthyFoodName) {
        logger.info("Handling request for healthy food suggestion, with unhealthy food name: "+ unhealthyFoodName );
        ArrayList<String> healthyFoods = foodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFoodName);
        if(healthyFoods==null){
            logger.info("Unknown food with name: "+ unhealthyFoodName);
            return ResponseEntity.noContent().header("Unknown Food", unhealthyFoodName).build();
        }
        else if(healthyFoods.size()<=0){
            logger.info("Found no healthy food suggestions for the unhealthy food name: "+ unhealthyFoodName);
            return ResponseEntity.noContent().header("No suggestions", unhealthyFoodName).build();
        }else{
            logger.info("Successfully generated a response for unhealthy food name: "+ unhealthyFoodName);
            String json = new Gson().toJson(healthyFoods);
            return ResponseEntity.ok(json);
        }
    }
    @ApiOperation(value = "provides all known foods")
    @RequestMapping(value = "/knownFoods", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public List<Food> knownFoodLookUp() {
        logger.info("Handling request for known foods. ");
        List<Food> knownFoods = foodLookupService.findKnownFoods();
        return knownFoods;
    }

}
