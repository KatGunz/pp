import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { Location } from '@angular/common';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { Router, ActivatedRoute, NavigationEnd, Event, NavigationStart, NavigationError, NavigationCancel } from '@angular/router';
import { FoodService } from '../../services/services.food/food.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-suggested-foods',
  templateUrl: './suggested-foods.component.html',
  styleUrls: ['./suggested-foods.component.css']
})
export class SuggestedFoodsComponent implements OnInit, OnDestroy {
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
    private router: Router,
  ) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit() {
    this.setFoodSuggestions();
    this.subscription = this.router.events.subscribe((event)=>this.setFoodSuggestions);
  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }
  goBack():void{
    this.location.back();
  }
  handleRouteChange(event: Event):void{
    if(event instanceof NavigationStart){
    }else if (event instanceof NavigationEnd){
      this.setFoodSuggestions
    } else if(event instanceof NavigationError){
    } else if(event instanceof NavigationCancel){
    }
  }
  setFoodSuggestions(){
    var searchQuery = this.route.snapshot.paramMap.get('searchQuery');
    console.log(searchQuery);
    this.foodService.suggestFoods(searchQuery)
      .subscribe(healthyFoods => this.initFoodSuggestions(healthyFoods));
  }
  initFoodSuggestions(healthyFoods: FoodDTO[]):void{
    if(!healthyFoods){
      this.matSnackBar.open("No Results Found","",{duration:3000});
      healthyFoods = [];
    }
    this.initDataSource(healthyFoods);
  }
  initDataSource(healthyFoods: FoodDTO[]): void{
    this.dataSource = new MatTableDataSource(healthyFoods);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

}
