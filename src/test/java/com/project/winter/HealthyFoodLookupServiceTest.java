package com.project.winter;

import com.project.winter.DAO.FoodDAO;
import com.project.winter.DAO.UnhealthyToHealthyDAO;
import com.project.winter.Services.HealthyFoodLookupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class HealthyFoodLookupServiceTest {
    @Mock
    private FoodDAO foodDAO;

    @Mock
    private UnhealthyToHealthyDAO unhealthyToHealthyDAO;

    @InjectMocks
    private HealthyFoodLookupService healthyFoodLookupService;

    @Test
    public void testFindHealthyFoodsNameByUnhealthyFoodNameWithUnknownFood(){
        ArrayList<String> result;
        String unhealthyFood = "my cooking";
        Mockito.when(foodDAO.findByFoodName(unhealthyFood)).thenReturn(null);
        healthyFoodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFood);
        Mockito.verify(foodDAO).findByFoodName(unhealthyFood);
        Mockito.verifyNoMoreInteractions(foodDAO);
        Mockito.verifyZeroInteractions(unhealthyToHealthyDAO);
    }
    @Test
    public void testFindHealthyFoodsNameByUnhealthyFoodNameWithNoSuggestions(){

    }
    @Test
    public void testFindHealthyFoodsNameByUnhealthyFoodNameWithSuggestions(){

    }
}
