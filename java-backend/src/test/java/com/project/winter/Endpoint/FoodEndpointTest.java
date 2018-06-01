package com.project.winter.Endpoint;

import com.project.winter.Services.FoodLookupService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

}
