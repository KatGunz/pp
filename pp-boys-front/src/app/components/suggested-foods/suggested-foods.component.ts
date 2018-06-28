import { Component, OnInit } from '@angular/core';
import { FoodService } from '../../services/services.food/food.service'; 
import { FoodDTO } from '../../domain/Food';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';
import { DataService } from '../../services/services.data/data.service';

@Component({
  selector: 'app-suggested-foods',
  templateUrl: './suggested-foods.component.html',
  styleUrls: ['./suggested-foods.component.css']
})
export class SuggestedFoodsComponent implements OnInit {
  healthyFoods: FoodDTO[];

  constructor(
    private location: Location,
    private foodService: FoodService,
    private snackBar: MatSnackBar,
    private dataService: DataService
  ) { }

  ngOnInit() {
    this.healthyFoods = this.dataService.removeFromFoodResultCubby();
  }
  goBack():void{
    this.location.back();
  }
}
