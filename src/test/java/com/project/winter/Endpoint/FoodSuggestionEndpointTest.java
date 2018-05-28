package com.project.winter.Endpoint;

import com.project.winter.Services.HealthyFoodLookupService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class FoodSuggestionEndpointTest {

    private MockMvc mockMvc;

    @Mock
    private HealthyFoodLookupService healthyFoodLookupService;

    @InjectMocks
    private FoodSuggestionEndpoint foodSuggestionEndpoint;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(foodSuggestionEndpoint)
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

}
