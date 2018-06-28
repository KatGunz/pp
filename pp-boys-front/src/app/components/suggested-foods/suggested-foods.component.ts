import { Component, OnInit } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { Location } from '@angular/common';
import { DataService } from '../../services/services.data/data.service';
import { MatSort, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-suggested-foods',
  templateUrl: './suggested-foods.component.html',
  styleUrls: ['./suggested-foods.component.css']
})
export class SuggestedFoodsComponent implements OnInit {
  healthyFoods: FoodDTO[];
  // dataSource = new MatTableDataSource();
  dataSource: MatTableDataSource<FoodDTO>;
  foodNameColumn = ['foodName', 'calories', 'totalCarbs', 'totalFat'];

  constructor(
    private location: Location,
    private dataService: DataService
  ) { }

  ngOnInit() {
    this.healthyFoods = this.dataService.readFoodResultCubby();
    this.dataSource = new MatTableDataSource(this.healthyFoods);
  }
  goBack():void{
    this.location.back();
  }
}
