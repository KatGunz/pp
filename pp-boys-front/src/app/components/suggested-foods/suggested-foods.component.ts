import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { Location } from '@angular/common';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { Router, ActivatedRoute } from '@angular/router';
import { FoodService } from '../../services/services.food/food.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-suggested-foods',
  templateUrl: './suggested-foods.component.html',
  styleUrls: ['./suggested-foods.component.css']
})
export class SuggestedFoodsComponent implements OnInit, OnDestroy {
  healthyFoods: FoodDTO[];
  dataSource: MatTableDataSource<FoodDTO>;
  foodNameColumn = ['foodName', 'calories', 'totalCarbs', 'totalFat'];
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  private subscription: Subscription;
  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private foodService: FoodService,
    private matSnackBar: MatSnackBar,
    private router: Router
  ) {}

  ngOnInit() {
    this.setFoodSuggestions();
    this.subscription = this.router.events.subscribe((val)=>this.setFoodSuggestions());
  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
  goBack():void{
    this.location.back();
  }
  setFoodSuggestions(){
    this.foodService.suggestFoods(this.route.snapshot.paramMap.get('searchQuery'))
      .subscribe(healthyFoods => this.initFoodSuggestions(healthyFoods));
  }
  initFoodSuggestions(healthyFoods: FoodDTO[]):void{
    this.healthyFoods = healthyFoods;
    if(!healthyFoods){
      this.matSnackBar.open("No Results Found","",{duration:3000});
      this.router.navigate([`no-results`]);
      return;
    }
    this.dataSource = new MatTableDataSource(this.healthyFoods);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

}
