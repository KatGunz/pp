import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './routing/app-routing.module';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

import { AppComponent } from './app.component';
import { FoodsComponent } from './components/foods/foods.component';
import { FoodDetailComponent } from './components/food-detail/food-detail.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SuggestedFoodsComponent } from './components/suggested-foods/suggested-foods.component';

@NgModule({
  declarations: [
    AppComponent,
    FoodsComponent,
    FoodDetailComponent,
    DashboardComponent,
    SuggestedFoodsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    MatSnackBarModule,
    MatButtonModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
