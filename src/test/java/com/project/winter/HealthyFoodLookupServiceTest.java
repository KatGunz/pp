package com.project.winter;

import com.project.winter.DAO.FoodDAO;
import com.project.winter.DAO.UnhealthyToHealthyDAO;
import com.project.winter.DTO.Food;
import com.project.winter.Services.HealthyFoodLookupService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

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
        result = healthyFoodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFood);
        Mockito.verify(foodDAO).findByFoodName(unhealthyFood);
        Mockito.verifyNoMoreInteractions(foodDAO);
        Mockito.verifyZeroInteractions(unhealthyToHealthyDAO);
        Assert.assertNull(result);
    }
    @Test
    public void testFindHealthyFoodsNameByUnhealthyFoodNameWithNoSuggestions(){
        ArrayList<String> result;
        String unhealthyFood = "poo";
        Mockito.when(foodDAO.findByFoodName(unhealthyFood)).thenReturn(Collections.emptyList());
        result = healthyFoodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFood);
        Mockito.verify(foodDAO).findByFoodName(unhealthyFood);
        Mockito.verifyNoMoreInteractions(foodDAO);
        Mockito.verify(unhealthyToHealthyDAO);
        Mockito.verifyNoMoreInteractions(unhealthyToHealthyDAO);
        Assert.assertNotNull(result);
    }
    @Test
    public void testFindHealthyFoodsNameByUnhealthyFoodNameWithSuggestions(){
        ArrayList<String> result;
        String unhealthyFood = "pee";
        ArrayList<Food> myResult = new ArrayList<>();
        Mockito.when(foodDAO.findByFoodName(unhealthyFood)).thenReturn(myResult);
        result = healthyFoodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFood);
        Mockito.verify(foodDAO).findByFoodName(unhealthyFood);
        Mockito.verifyNoMoreInteractions(foodDAO);
        Mockito.verify(unhealthyToHealthyDAO);
        Mockito.verifyNoMoreInteractions(unhealthyToHealthyDAO);
        Assert.assertNotNull(result);
    }
}
