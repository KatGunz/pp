import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { FoodService } from '../../services/services.food/food.service';
import { FoodDTO } from '../../domain/Food';
import { MatSnackBar } from '@angular/material/snack-bar';

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
    private snackBar: MatSnackBar
  ) {}
 
  ngOnInit() {
  }
  private onSubmit(searchQuery: string): void {
    if(!searchQuery){
      return;
    }
    this.searchQuery = searchQuery;
    this.router.navigate([`suggested-foods/${searchQuery}`]);
  }
  
  
  
}