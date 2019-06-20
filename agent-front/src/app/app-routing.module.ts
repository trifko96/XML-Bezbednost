import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/AuthGuard';
import { HomeComponent } from './home/home.component';
import { RandomGuard } from './guards/RandomGuard';
import { HomeAccDetailsComponent } from './home-acc-details/home-acc-details.component';
import { HomeNewaccComponent } from './home-newacc/home-newacc.component';
import { HomePriceComponent } from './home-price/home-price.component';
import { HomeReservationsComponent } from './home-reservations/home-reservations.component';
import { HomeMessaggesComponent } from './home-messagges/home-messagges.component';

const routes: Route[] = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent, canActivate: [AuthGuard]},
  {path: 'home', component: HomeComponent, canActivate: [RandomGuard],
    children : [
      {path: '', redirectTo: 'accDetails', pathMatch: 'full'},
      {path: 'accDetails', component: HomeAccDetailsComponent},
      {path: 'newAcc', component: HomeNewaccComponent},
      {path: 'price', component: HomePriceComponent},
      {path: 'reservations', component: HomeReservationsComponent},
      {path: 'messagges', component: HomeMessaggesComponent},
      {path: '**', redirectTo: 'accDetails', pathMatch: 'full'},
    ]
  },
  {path: '**', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
