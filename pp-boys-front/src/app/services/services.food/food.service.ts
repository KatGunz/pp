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
  private hostAndPort = 'http://localhost:8080/'
  private foodEndpointBaseUrl = 'api/foodLookup/'
  private knownFoodsEndpoint = 'knownFoods';
  private findFoodEndpoint = 'findFood'
  getFoods(): Observable<Food[]> {
    this.messageService.clear();
    this.log('fetched foods');
    // return of(FOODS);
    return this.http.get<Food[]>(this.hostAndPort + this.foodEndpointBaseUrl + this.knownFoodsEndpoint);
  }
  getFoodByName(foodName: String): Observable<Food> {
    return this.http.get<Food>(this.hostAndPort + this.foodEndpointBaseUrl + foodName);
  }
  suggestFoods(unhealthyFood: String): Observable<Food[]> {
    return this.http.get<Food[]>(this.hostAndPort + this.foodEndpointBaseUrl + unhealthyFood);
  }
}
