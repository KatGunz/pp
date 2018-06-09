import { Component, OnInit } from '@angular/core';
import { Food } from '../../domain/food';
import { FoodService } from '../../services/services.food/food.service';
import { MessageService } from '../../services/services.message/message.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  foods: Food[] = [];
  healthyFoods: Food[];
  unhealthyFood: String;

  constructor(private foodService: FoodService, private messageService: MessageService) { }
 
  ngOnInit() {
  }
 
  suggestFoods(unhealthyFoods: String): void {
    this.foodService.suggestFoods(unhealthyFoods)
      .subscribe(healthyFoods => this.displayFoods(healthyFoods));
  }
  private displayFoods(healthyFoods: Food[]) {
    if(healthyFoods){
      this.healthyFoods = healthyFoods;
      this.messageService.clear();
      this.messageService.add("Search Successful.");
    }else{
        this.messageService.clear();
        this.messageService.add("No Results Found.");
    }
  }
}
