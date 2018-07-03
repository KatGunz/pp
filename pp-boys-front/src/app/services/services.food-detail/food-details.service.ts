import { Injectable } from '@angular/core';
import { FoodDTO } from '../../domain/Food';
import { Observable } from 'rxjs';
import { KeyValuePairing } from 'src/app/domain/KeyValuePairing';
import { forEach } from '@angular/router/src/utils/collection';

@Injectable({
  providedIn: 'root'
})
export class FoodDetailsService {

  constructor() { }
  
  makeKeyValuePairingArrayFromFoodDTO(foodDTO: FoodDTO): KeyValuePairing[]{
    var keyValuePairingArray = new Array<KeyValuePairing>();
    for(var key in foodDTO){
      if(key==="foodName"){continue;}
      var keyValuePairing: KeyValuePairing = new KeyValuePairing(key, foodDTO[key]+"");
      keyValuePairingArray.push(keyValuePairing);
    }
    return keyValuePairingArray;
  }

}