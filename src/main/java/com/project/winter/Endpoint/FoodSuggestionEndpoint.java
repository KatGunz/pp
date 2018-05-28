package com.project.winter.Endpoint;

import com.project.winter.Services.HealthyFoodLookupService;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/foodLookup")
public class FoodSuggestionEndpoint {

    @Autowired
    final static Logger logger = Logger.getLogger(FoodSuggestionEndpoint.class);

    @ApiOperation(value = "suggests healthy food given unhealthy food")
    @RequestMapping(value = "/{unhealthyFoodName}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> findHealthyFoodNameByUnhealthyFoodName(@PathVariable String unhealthyFoodName) {
        logger.info("Handling request for healthy food suggestion, with unhealthy food name: "+ unhealthyFoodName );
        ArrayList<String> healthyFoods = healthyFoodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFoodName);
        if(healthyFoods==null){
            logger.info("Unknown food with name: "+ unhealthyFoodName);
            return ResponseEntity.status(201).header("Unknown Food").body(null);
        }
        else if(healthyFoods.size()<=0){
            logger.info("Found no healthy food suggestions for the unhealthy food name: "+ unhealthyFoodName);
            String json = new Gson().toJson("{}");
            return ResponseEntity.status(202).header("Could not find a suggestion").body(json);
        }else{
            logger.info("Successfully generated a response for unhealthy food name: "+ unhealthyFoodName);
            String json = new Gson().toJson(healthyFoods);
            return ResponseEntity.ok(json);
        }
    }
}
