package project.boys.pp.Endpoint;

import com.google.gson.Gson;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import project.boys.pp.DTO.Food;
import project.boys.pp.Endpoint.FoodEndpoint;
import project.boys.pp.Services.FoodLookupService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void testFindHealthyFoodNameByUnhealthyFoodNameWithSuccess(){

    }
    @Test
    public void testFindHealthyFoodNameByUnhealthyFoodNameWithNoSuggestions(){

    }
    @Test
    public void testFindHealthyFoodNameByUnhealthyFoodNameWithUnknownFood(){

    }
    @Test
    public void testKnownFoodLookUp() throws Exception {
        List<Food> foodStub = new ArrayList<>();
        Food food = new Food();
        food.setFoodName("apple");
        foodStub.add(food);
        Mockito.when(foodLookupService.findKnownFoods()).thenReturn(foodStub);
        mockMvc.perform(get("/api/foodLookup/knownFoods").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(new Gson().toJson(foodStub)));
        Mockito.verify(foodLookupService).findKnownFoods();
        Mockito.verifyNoMoreInteractions(foodLookupService);
    }

}
