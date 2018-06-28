import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { FoodService } from '../../services/services.food/food.service';
import { FoodDTO } from '../../domain/Food';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DataService } from '../../services/services.data/data.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  searchQuery: string;
  healthyFoods: FoodDTO[];
  constructor(
    private router: Router, 
    private route: ActivatedRoute,
    private foodService: FoodService,
    private snackBar: MatSnackBar,
    private dataService: DataService
  ) {}
 
  ngOnInit() {
  }
  private onSubmit(searchQuery: string): void {
    this.searchQuery = searchQuery;
    this.suggestFoods(this.searchQuery);
  }
  private suggestFoods(unhealthyFood: string): void {
    this.foodService.suggestFoods(unhealthyFood)
      .subscribe(healthyFoods => this.passResults(healthyFoods));
  }
  private passResults(healthyFoods: FoodDTO[]): void {
    if(healthyFoods){
      this.healthyFoods = healthyFoods;
      var isFull = this.dataService.addToFoodResultCubby(healthyFoods);
      if(isFull){
        console.log("Cubby was full!");
        return;
      }
      this.router.navigate([`suggested-foods/${this.searchQuery}`]);
    }
    else{
      this.snackBar.open("No Results Found.", null, {
        duration: 3000
      });
    }
  }
  
  
}