import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { FoodDTO } from '../../domain/Food';
import { FoodService } from '../../services/services.food/food.service';
import { Observable } from 'rxjs';
import { MessageService } from '../../services/services.message/message.service'

@Component({
  selector: 'app-food-detail',
  templateUrl: './food-detail.component.html',
  styleUrls: ['./food-detail.component.css']
})

export class FoodDetailComponent implements OnInit {

  food: FoodDTO;
  
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private foodService: FoodService,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    this.getFoodByName();
  }
  getFoodByName():void{
    const foodName = this.route.snapshot.paramMap.get('foodName');
    this.foodService.getFoodByName(foodName)
      .subscribe(food => this.assignFood(food));
  }
  private assignFood(food: FoodDTO): void{
    this.food = food;
  }
  goBack():void{
    this.location.back();
  }
  

}
