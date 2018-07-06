import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FoodDTO } from '../app/domain/Food';

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
    private router: Router
  ){}

  ngOnInit(){
  }
  private onSubmit(searchQuery: string): void {
    if(!searchQuery){
      return;
    }
    this.searchQuery = searchQuery;
    this.router.navigate([`suggested-foods/${searchQuery}`]);
  }
  
  
}
