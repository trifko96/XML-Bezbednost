import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { HomeAccommodationComponent } from './home-accommodation/home-accommodation.component';

const routes: Route[] = [
  {path: '', redirectTo:'/home/accommodation', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'home', component: HomeComponent,
    children : [
      {path: '', redirectTo: '/accommodation', pathMatch: 'full'},
      {path: 'accommodation', component: HomeAccommodationComponent}
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
