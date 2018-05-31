import { Injectable } from '@angular/core';
import { Food } from '../../domain.classes/Food';
import { FOODS } from '../../mock.data/mock-food';
import { Observable, of } from 'rxjs';
import { MessageService } from '../services.message/message.service';

@Injectable({
  providedIn: 'root'
})

export class FoodService {

  constructor(private messageService: MessageService) { }

  getFoods(): Observable<Food[]> {
    this.messageService.add('FoodService: fetched foods');
    return of(FOODS);
  }

}
