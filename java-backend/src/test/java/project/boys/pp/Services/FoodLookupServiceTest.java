package project.boys.pp.Services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import project.boys.pp.DAO.FoodDAO;
import project.boys.pp.DAO.UnhealthyToHealthyDAO;
import project.boys.pp.DTO.Food;
import project.boys.pp.DTO.UnhealthyToHealthy;
import project.boys.pp.Services.FoodLookupService;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FoodLookupServiceTest {
    @Mock
    private FoodDAO foodDAO;

    @Mock
    private UnhealthyToHealthyDAO unhealthyToHealthyDAO;

    @InjectMocks
    private FoodLookupService foodLookupService;

    @Test
    public void testFindHealthyFoodsNameByUnhealthyFoodNameWithUnknownFood(){
        ArrayList<String> result;
        String unhealthyFood = "my cooking";
        Mockito.when(foodDAO.findByFoodName(unhealthyFood)).thenReturn(null);
        result = foodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFood);
        Mockito.verify(foodDAO).findByFoodName(unhealthyFood);
        Mockito.verifyNoMoreInteractions(foodDAO);
        Mockito.verifyZeroInteractions(unhealthyToHealthyDAO);
        Assert.assertNull(result);
    }
    @Test
    public void testFindHealthyFoodsNameByUnhealthyFoodNameWithNoSuggestions(){
        ArrayList<String> result;
        String unhealthyFood = "unhealthy food";
        long unhealthyFoodId = 8;
        Food food = new Food();
        List<Food> existingFood = new ArrayList<>();
        existingFood.add(food);
        food.setFoodId(unhealthyFoodId);
        Mockito.when(foodDAO.findByFoodName(unhealthyFood)).thenReturn(existingFood);
        Mockito.when(unhealthyToHealthyDAO.getAllByUnhealthyFoodId(unhealthyFoodId)).thenReturn(null);
        result = foodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFood);
        Mockito.verify(foodDAO).findByFoodName(unhealthyFood);
        Mockito.verifyNoMoreInteractions(foodDAO);
        Mockito.verify(unhealthyToHealthyDAO).getAllByUnhealthyFoodId(unhealthyFoodId);
        Mockito.verifyNoMoreInteractions(unhealthyToHealthyDAO);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.size()==0);
    }
    @Test
    public void testFindHealthyFoodsNameByUnhealthyFoodNameWithSuggestions(){
        ArrayList<String> result;
        String unhealthyFoodName = "unhealthy food";
        long unhealthyFoodId = 5L;
        Food unhealthyFood = new Food();
        Food healthyFood = new Food();
        String healthyFoodName = "healthy food";
        healthyFood.setFoodName(healthyFoodName);
        List<Food> existingFood = new ArrayList<>();
        List<Food> healthyFoodList = new ArrayList<>();
        existingFood.add(unhealthyFood);
        unhealthyFood.setFoodId(unhealthyFoodId);
        healthyFoodList.add(healthyFood);
        UnhealthyToHealthy healthySuggestion = new UnhealthyToHealthy();
        healthySuggestion.setHealthyFoodId(3L);
        List<UnhealthyToHealthy> healthySuggestionsList = new ArrayList<>();
        healthySuggestionsList.add(healthySuggestion);
        Mockito.when(foodDAO.findByFoodName(unhealthyFoodName)).thenReturn(existingFood);
        Mockito.when(foodDAO.findAll(Mockito.any(ArrayList.class))).thenReturn(healthyFoodList);
        Mockito.when(unhealthyToHealthyDAO.getAllByUnhealthyFoodId(unhealthyFoodId)).thenReturn(healthySuggestionsList);
        result = foodLookupService.findHealthyFoodsNameByUnhealthyFoodName(unhealthyFoodName);
        Mockito.verify(foodDAO).findByFoodName(unhealthyFoodName);
        Mockito.verify(foodDAO).findAll(Mockito.any(ArrayList.class));
        Mockito.verifyNoMoreInteractions(foodDAO);
        Mockito.verify(unhealthyToHealthyDAO).getAllByUnhealthyFoodId(unhealthyFoodId);
        Mockito.verifyNoMoreInteractions(unhealthyToHealthyDAO);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.size()==1);
        Assert.assertEquals(healthyFoodName,result.get(0));
    }
    @Test
    public void testFindKnownFoods(){
        List<Food> knownFoods = new ArrayList<>();
        Mockito.when(foodDAO.findAll()).thenReturn(knownFoods);
        List<Food> result = foodLookupService.findKnownFoods();
        Mockito.verify(foodDAO).findAll();
        Mockito.verifyNoMoreInteractions(foodDAO);
        Mockito.verifyZeroInteractions(unhealthyToHealthyDAO);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.size()==0);
    }

}
