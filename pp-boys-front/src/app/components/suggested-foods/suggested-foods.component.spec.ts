import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuggestedFoodsComponent } from './suggested-foods.component';

describe('SuggestedFoodsComponent', () => {
  let component: SuggestedFoodsComponent;
  let fixture: ComponentFixture<SuggestedFoodsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuggestedFoodsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuggestedFoodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
