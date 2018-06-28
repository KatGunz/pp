import { Injectable } from '@angular/core';
import { FoodDTO } from '../../domain/Food';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  //foodResultCubby and searchQueryCubby are used to pass data
  // from dashboard component to suggested-foods component
  foodResultCubby: FoodDTO[] = null;

  assignToFoodResultCubby(data: FoodDTO[]): void {
    this.foodResultCubby = data;
  }
  readFoodResultCubby(): FoodDTO[] {
    //returns null if cubby is empty
    var foods: FoodDTO[] = this.foodResultCubby;
    return foods;
  }
}
