import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { FoodService } from 'src/app/services/services.food/food.service';
import { FoodDTO } from '../app/domain/Food';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DataService } from '../app/services/services.data/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Food Suggestion App';
  searchQuery: string;
  healthyFoods: FoodDTO[];
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private foodService: FoodService,
    private snackBar: MatSnackBar,
    private dataService: DataService
  ){}

  ngOnInit(){
  }
  private onSubmit(searchQuery: string): void {
    if(!searchQuery){
      return;
    }
    this.searchQuery = searchQuery;
    this.suggestFoods(this.searchQuery);
  }
  private suggestFoods(unhealthyFood: string): void {
    this.foodService.suggestFoods(unhealthyFood)
      .subscribe(healthyFoods => this.passResults(healthyFoods));
  }
  private passResults(healthyFoods: FoodDTO[]): void {
    if(this.router.url === 'suggested-foods'){
      //TODO: fix this line
      console.log("TEST");
      this.healthyFoods = healthyFoods;
      this.dataService.assignToFoodResultCubby(healthyFoods);
    }else{
      if(healthyFoods){
        this.healthyFoods = healthyFoods;
        this.dataService.assignToFoodResultCubby(healthyFoods);
        this.router.navigate([`suggested-foods`]);
      }
      else{
        this.snackBar.open("No Results Found.", null, {
          duration: 3000
        });
      }
    }
  }
  
  
}
