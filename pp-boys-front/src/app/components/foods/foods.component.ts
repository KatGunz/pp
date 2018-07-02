import { Component, OnInit } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { FoodService } from '../../services/services.food/food.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css']
})

export class FoodsComponent implements OnInit {

  foods: FoodDTO[];

  constructor(
        private foodService: FoodService,
        private location: Location
  ) { }

  ngOnInit() {
    this.getFoods();
  }

  getFoods(): void {
    this.foodService.getFoods()
      .subscribe(foods => this.foods = foods);
  }
  goBack():void{
    this.location.back();
  }
}
