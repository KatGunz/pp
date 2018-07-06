import { Component, OnInit, ViewChild, DoCheck } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { Location } from '@angular/common';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { ActivatedRoute } from '@angular/router';

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
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.dataSource = new MatTableDataSource(this.healthyFoods);
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }
  ngDoCheck(){
    console.log("Current route: "+ this.route.snapshot.url);
    this.dataSource = new MatTableDataSource(this.healthyFoods);
  }
  goBack():void{
    this.location.back();
  }
}
