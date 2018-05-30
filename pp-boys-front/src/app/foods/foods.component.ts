import { Component, OnInit } from '@angular/core';
import { Food } from './Food';

@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css']
})

export class FoodsComponent implements OnInit {
  
  food : Food = {
    id: 1,
    name: 'example_food'
  };

  constructor() { }

  ngOnInit() {
  }
  

}
