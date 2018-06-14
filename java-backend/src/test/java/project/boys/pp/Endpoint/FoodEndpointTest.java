package project.boys.pp.Endpoint;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import project.boys.pp.DTO.FoodDTO;
import project.boys.pp.Services.FoodLookupService;

import javax.persistence.NonUniqueResultException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class FoodEndpointTest {

    private MockMvc mockMvc;


    @Mock
    private FoodLookupService foodLookupService;

    @InjectMocks
    private FoodEndpoint foodEndpoint;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(foodEndpoint)
                .build();
    }

    @Test
    public void testFindHealthyFoodNameByUnhealthyFoodNameWithUnknownFood() throws Exception{
        String unknownFoodStub = "unknown food";
        Mockito.when(foodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unknownFoodStub)).thenReturn(null);
        mockMvc.perform(get("/api/foodLookup/" + unknownFoodStub).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNoContent())
                .andExpect(header().stringValues("Unknown Food", unknownFoodStub));
        Mockito.verify(foodLookupService).findHealthyFoodsNameByUnhealthyFoodName(unknownFoodStub);
        Mockito.verifyNoMoreInteractions(foodLookupService);
    }

    @Test
    public void testFindHealthyFoodNameByUnhealthyFoodNameWithNoSuggestions() throws Exception{
        String unhealthyFoodStub = "unhealthy food";
        ArrayList<FoodDTO> emptyArrayListStub = new ArrayList<>();
        Mockito.when(foodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFoodStub)).thenReturn(emptyArrayListStub);
        mockMvc.perform(get("/api/foodLookup/" + unhealthyFoodStub).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNoContent())
                .andExpect(header().stringValues("No suggestions", unhealthyFoodStub));
        Mockito.verify(foodLookupService).findHealthyFoodsNameByUnhealthyFoodName(unhealthyFoodStub);
        Mockito.verifyNoMoreInteractions(foodLookupService);
    }

    @Test
    public void testFindHealthyFoodNameByUnhealthyFoodNameWithSuccess() throws Exception{
        String unhealthyFoodStub = "unhealthy food";
        FoodDTO healthyFoodDTO = new FoodDTO();
        healthyFoodDTO.setFoodName("healthy food");
        ArrayList<FoodDTO> allHealthyMatchesStub = new ArrayList<>();
        allHealthyMatchesStub.add(healthyFoodDTO);
        Mockito.when(foodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFoodStub)).thenReturn(allHealthyMatchesStub);
        mockMvc.perform(get("/api/foodLookup/" + unhealthyFoodStub).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(new Gson().toJson(allHealthyMatchesStub)));
        Mockito.verify(foodLookupService).findHealthyFoodsNameByUnhealthyFoodName(unhealthyFoodStub);
        Mockito.verifyNoMoreInteractions(foodLookupService);
    }

    @Test
    public void testKnownFoodLookUp() throws Exception {
        List<FoodDTO> foodListStub = new ArrayList<>();
        FoodDTO food = new FoodDTO();
        food.setFoodName("apple");
        foodListStub.add(food);
        Mockito.when(foodLookupService.findKnownFoods()).thenReturn(foodListStub);
        mockMvc.perform(get("/api/foodLookup/knownFoods").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(new Gson().toJson(foodListStub)));
        Mockito.verify(foodLookupService).findKnownFoods();
        Mockito.verifyNoMoreInteractions(foodLookupService);
    }
    @Test
    public void testfindFoodByNameWithException() throws Exception{
        String foodName = "bacon";
        Mockito.when(foodLookupService.findFood(foodName)).thenThrow(NonUniqueResultException.class);
        mockMvc.perform(get("/api/foodLookup/findFood/" + foodName).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().is(500))
                .andExpect(header().stringValues("Server Error, non-unique food name", foodName));
        Mockito.verify(foodLookupService).findFood(foodName);
        Mockito.verifyNoMoreInteractions(foodLookupService);
    }
    @Test
    public void testFindFoodByNameWithSuccess() throws Exception{
        String foodNameStub = "food";
        FoodDTO foodDTOStub = new FoodDTO();
        foodDTOStub.setFoodName(foodNameStub);
        Mockito.when(foodLookupService.findFood(foodNameStub)).thenReturn(foodDTOStub);
        mockMvc.perform(get("/api/foodLookup/findFood/" + foodNameStub).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(new Gson().toJson(foodDTOStub)));
        Mockito.verify(foodLookupService).findFood(foodNameStub);
        Mockito.verifyNoMoreInteractions(foodLookupService);
    }
}
