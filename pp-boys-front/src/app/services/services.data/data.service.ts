import { Injectable } from '@angular/core';
import { FoodDTO } from '../../domain/Food';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  //foodResultCubby and searchQueryCubby are used to pass data
  // from dashboard component to suggested-foods component
  foodResultCubby: FoodDTO[] = null;

  addToFoodResultCubby(data: FoodDTO[]): boolean {
    if(this.foodResultCubby){
      // returns false if cubby is full
      return false;
    }else{
      this.foodResultCubby = data;
    }
  }
  removeFromFoodResultCubby(): FoodDTO[] {
    //returns null if cubby is empty
    var foods: FoodDTO[] = this.foodResultCubby;
    this.foodResultCubby = null;
    return foods;
  }
}
