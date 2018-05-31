import { Component, OnInit, Input } from '@angular/core';
import { Food } from '../../domain/Food';

@Component({
  selector: 'app-food-detail',
  templateUrl: './food-detail.component.html',
  styleUrls: ['./food-detail.component.css']
})

export class FoodDetailComponent implements OnInit {

  @Input() food = Food;
  constructor() { }

  ngOnInit() {
  }

}
