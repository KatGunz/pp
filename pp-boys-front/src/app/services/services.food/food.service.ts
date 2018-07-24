import { Injectable } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { Observable} from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class FoodService {

  constructor(private http: HttpClient) {}

  private hostAndPort = 'http://localhost:8081/';
  private foodEndpointBaseUrl = 'api/foodLookup/';
  private knownFoodsEndpoint = 'knownFoods';
  private findFoodEndpoint = 'findFood/';
  getFoods(): Observable<FoodDTO[]> {
    return this.http.get<FoodDTO[]>(this.hostAndPort + this.foodEndpointBaseUrl + this.knownFoodsEndpoint);
  }
  getFoodByName(foodName: String): Observable<FoodDTO> {
    return this.http.get<FoodDTO>(this.hostAndPort + this.foodEndpointBaseUrl + this.findFoodEndpoint + foodName);
  }
  suggestFoods(unhealthyFood: String): Observable<FoodDTO[]> {
    return this.http.get<FoodDTO[]>(this.hostAndPort + this.foodEndpointBaseUrl + unhealthyFood);
  }
}
