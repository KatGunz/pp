import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { FoodsComponent } from '../components/foods/foods.component';
import { DashboardComponent }   from '../components/dashboard/dashboard.component';
import { FoodDetailComponent } from '../components/food-detail/food-detail.component'

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'foods', component: FoodsComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'food-details/:id', component: FoodDetailComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})

export class AppRoutingModule { }
