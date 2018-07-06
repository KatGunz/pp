import { Component, OnInit, ViewChild } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { Location } from '@angular/common';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { ActivatedRoute } from '@angular/router';
import { FoodService } from '../../services/services.food/food.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-suggested-foods',
  templateUrl: './suggested-foods.component.html',
  styleUrls: ['./suggested-foods.component.css']
})
export class SuggestedFoodsComponent implements OnInit {
  healthyFoods: FoodDTO[];
  dataSource: MatTableDataSource<FoodDTO>;
  foodNameColumn = ['foodName', 'calories', 'totalCarbs', 'totalFat'];
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private foodService: FoodService,
    private matSnackBar: MatSnackBar,
    private router: Router
  ) {}

  ngOnInit() {
    this.setFoodSuggestions();
    this.router.events.subscribe((val)=>this.setFoodSuggestions());
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
      console.log("here")
      this.matSnackBar.open("No Results Found","",{duration:3000});
      return;
    }
    this.dataSource = new MatTableDataSource(this.healthyFoods);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

}
