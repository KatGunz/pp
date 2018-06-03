import { Injectable } from '@angular/core';
import { Food } from '../../domain/Food';
import { FOODS } from '../../mock.data/mock-food';
import { Observable, of } from 'rxjs';
import { MessageService } from '../services.message/message.service';

@Injectable({
  providedIn: 'root'
})

export class FoodService {

  constructor(private messageService: MessageService) { }

  getFoods(): Observable<Food[]> {
    this.messageService.clear();
    this.messageService.add('FoodService: fetched foods');
    return of(FOODS);
  }
  getFood(id: number): Observable<Food> {
    this.messageService.clear();
    this.messageService.add(`HeroService: fetched hero id=${id}`);
    return of(FOODS.find(food=>id===food.id));
  }

}
