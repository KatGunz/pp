import { Injectable } from '@angular/core';
import { Food } from '../../domain/Food';
import { FOODS } from '../../mock.data/mock-food';
import { Observable, of } from 'rxjs';
import { MessageService } from '../services.message/message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class FoodService {

  constructor(
    private http: HttpClient,
    private messageService: MessageService) {}

  private log(message: string) {
    this.messageService.add('FoodService: ' + message);
  }
  private foodsUrl = 'http://localhost:8080/api/foodLookup/knownFoods';

  getFoods(): Observable<Food[]> {
    this.messageService.clear();
    this.log('fetched foods');
    // return of(FOODS);
    return this.http.get<Food[]>(this.foodsUrl);
  }
  getFood(id: number): Observable<Food> {
    this.messageService.clear();
    this.log(`fetched food id=${id}`);
    return of(FOODS.find(food=>id===food.id));
  }

}
