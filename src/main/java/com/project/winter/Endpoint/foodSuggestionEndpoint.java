package com.project.winter.Endpoint;

import com.project.winter.DTO.Food;
import com.project.winter.Services.HealthyFoodLookupService;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/foodLookup")

public class foodSuggestionEndpoint {
    @Autowired
    private HealthyFoodLookupService healthyFoodLookupService;

    @ApiOperation(value = "suggests healthy food given unhealthy food", response = Food.class)
    @RequestMapping(value = "/{unhealthyFoodName}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<String> findHealthyFoodNameByUnhealthyFoodName(@PathVariable String unhealthyFoodName) {
        ArrayList<String> healthyFoods = healthyFoodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFoodName);
        if(healthyFoods.size()<=0){
            return ResponseEntity.noContent().build();
        }else{
            String json = new Gson().toJson(healthyFoods);
            return ResponseEntity.ok(json);
        }
    }
}
