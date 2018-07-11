import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { FoodsComponent } from '../components/foods/foods.component';
import { DashboardComponent }   from '../components/dashboard/dashboard.component';
import { FoodDetailComponent } from '../components/food-detail/food-detail.component'
import { SuggestedFoodsComponent } from '../components/suggested-foods/suggested-foods.component';
import { NoResultsComponent } from '../components/no-results/no-results.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  { path: 'foods', component: FoodsComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'food-details/:foodName', component: FoodDetailComponent},
  { 
    path: 'suggested-foods/:searchQuery', 
    component: SuggestedFoodsComponent,
    runGuardsAndResolvers: 'always',
  },
  { path: 'no-results', component: NoResultsComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'}),
  ],
  exports: [
    RouterModule,
  ],
  declarations: []
})

export class AppRoutingModule { }
