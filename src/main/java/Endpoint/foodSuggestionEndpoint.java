package Endpoint;

import Services.HealthyFoodLookupService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/foodLookup")
public class foodSuggestionEndpoint {
    @Autowired
    private HealthyFoodLookupService healthyFoodLookupService;

    @GetMapping(path = "/{unhealthyFoodName}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
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
