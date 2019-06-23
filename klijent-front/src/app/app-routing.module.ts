import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { HomeAccommodationComponent } from './home-accommodation/home-accommodation.component';
import { HomeLoggedInComponent } from './home-logged-in/home-logged-in.component';
import { HomeLoggedInAccComponent } from './home-logged-in-acc/home-logged-in-acc.component';
import { HomeLoggedInReservComponent } from './home-logged-in-reserv/home-logged-in-reserv.component';

const routes: Route[] = [
  {path: '', redirectTo:'/home/accommodation', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'home', component: HomeComponent,
    children : [
      {path: '', redirectTo: 'accommodation', pathMatch: 'full'},
      {path: 'accommodation', component: HomeAccommodationComponent}
    ]
  },
  {path: 'homeLogged', component:HomeLoggedInComponent,
    children : [
      {path: '', redirectTo : 'homeLoggedAcc', pathMatch: 'full'},
      {path: 'homeLoggedAcc', component: HomeLoggedInAccComponent},
      {path: 'homeLoggedRes', component: HomeLoggedInReservComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
