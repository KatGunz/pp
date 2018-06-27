import { Component, OnInit } from '@angular/core';
import { FoodDTO } from '../../domain/food';
import { FoodService } from '../../services/services.food/food.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  foods: FoodDTO[] = [];
  healthyFoods: FoodDTO[];
  unhealthyFood: String;

  constructor(
    private foodService: FoodService,
    private snackBar: MatSnackBar) {}
 
  ngOnInit() {
  }
 
  suggestFoods(unhealthyFoods: String): void {
    this.foodService.suggestFoods(unhealthyFoods)
      .subscribe(healthyFoods => this.displayFoods(healthyFoods));
  }
  private displayFoods(healthyFoods: FoodDTO[]) {
    if(healthyFoods){
      this.healthyFoods = healthyFoods;
    }else{
        this.snackBar.open("No Results Found.", null, {
          duration: 3000
        });
    }
  }
}
