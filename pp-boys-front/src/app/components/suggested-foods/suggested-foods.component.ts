import { Component, OnInit } from '@angular/core';
import { FoodService } from '../../services/services.food/food.service'; 
import { FoodDTO } from '../../domain/Food';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

@Component({
  selector: 'app-suggested-foods',
  templateUrl: './suggested-foods.component.html',
  styleUrls: ['./suggested-foods.component.css']
})
export class SuggestedFoodsComponent implements OnInit {
  healthyFoods: FoodDTO[] = [];
  searchQuery: string = "";
  constructor(
    private location: Location,
    private foodService: FoodService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.suggestFoods(this.searchQuery);
  }
  private suggestFoods(unhealthyFoods: String): void {
    this.foodService.suggestFoods(unhealthyFoods)
      .subscribe(healthyFoods => this.displayFoods(healthyFoods));
  }
  private displayFoods(healthyFoods: FoodDTO[]) {
    if(healthyFoods){
      this.healthyFoods = healthyFoods;
      this.snackBar.open("Results Found!", null, {
        duration: 3000
      });
    }
    else{
      this.snackBar.open("No Results Found.", null, {
        duration: 3000
      });
    }
  }
  goBack():void{
    this.location.back();
  }
}
