import { Component, OnInit } from '@angular/core';
import { Food } from '../../domain/food';
import { FoodService } from '../../services/services.food/food.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  foods: Food[] = [];

  constructor(private foodService: FoodService) { }

  ngOnInit() {
    this.getFoods();
  }

  getFoods(): void {
    this.foodService.getFoods()
      .subscribe(foods => this.foods = foods);
  }
}