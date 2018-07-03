import { Component, OnInit, ViewChild } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { Location } from '@angular/common';
import { DataService } from '../../services/services.data/data.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';

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
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private location: Location,
    private dataService: DataService
  ) { }

  ngOnInit() {
    this.healthyFoods = this.dataService.readFoodResultCubby();
    this.dataSource = new MatTableDataSource(this.healthyFoods);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }
  goBack():void{
    this.location.back();
  }
}
