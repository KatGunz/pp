import { TestBed, inject } from '@angular/core/testing';

import { FoodDetailsService } from './food-details.service';

describe('FoodDetailsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FoodDetailsService]
    });
  });

  it('should be created', inject([FoodDetailsService], (service: FoodDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
