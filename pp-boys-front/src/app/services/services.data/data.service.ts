import { Injectable } from '@angular/core';
import { FoodDTO } from '../../domain/Food';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  //foodResultCubby is used to pass data from dashboard
  //component to suggested-foods component
  foodResultCubby: FoodDTO[] = null;
  //navFoodResultCubby is used to pass data from app component
  //to suggested-foods component
  navFoodresultcubby: FoodDTO[] = null;

  assignToFoodResultCubby(data: FoodDTO[]): void {
    this.foodResultCubby = data;
  }
  readFoodResultCubby(): FoodDTO[] {
    //returns null if cubby is empty
    var foods: FoodDTO[] = this.foodResultCubby;
    return foods;
  }
  assignToNavFoodResultCubby(data: FoodDTO[]): void {
    this.navFoodresultcubby = data;
  }
  readNavFoodResultCubby(): FoodDTO[] {
    //returns null if cubby is empty
    var foods: FoodDTO[] = this.navFoodresultcubby;
    return foods;
  }
}
