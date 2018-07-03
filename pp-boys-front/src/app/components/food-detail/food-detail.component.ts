import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { FoodDTO } from '../../domain/Food';
import { KeyValuePairing } from '../../domain/KeyValuePairing';
import { FoodService } from '../../services/services.food/food.service';
import { FoodDetailsService } from '../../services/services.food-detail/food-details.service';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-food-detail',
  templateUrl: './food-detail.component.html',
  styleUrls: ['./food-detail.component.css']
})

export class FoodDetailComponent implements OnInit {

  food: FoodDTO;
  foodDetails: KeyValuePairing[];
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private foodService: FoodService,
    private foodDetailService: FoodDetailsService
  ) { }

  ngOnInit() {
    this.initFoodByName();
  }
  initFoodByName():void{
    const foodName = this.route.snapshot.paramMap.get('foodName');
    this.foodService.getFoodByName(foodName)
      .subscribe(food => this.assignFood(food));
  }
  makeKeyValuePairingArrayFromFoodDTO(): void{
    console.log(this.food.foodName);
    this.foodDetails= this.foodDetailService.makeKeyValuePairingArrayFromFoodDTO(this.food);
  }

  private assignFood(food: FoodDTO): void{
    this.food = food;
    this.makeKeyValuePairingArrayFromFoodDTO();
  }
  goBack():void{
    this.location.back();
  }
  

}
