import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './guards/AuthGuard';
import { RandomGuard } from './guards/RandomGuard';
import { HomeUserComponent } from './home-user/home-user.component';
import { HomeAccomodationComponent } from './home-accomodation/home-accomodation.component';
import { HomeCommentsComponent } from './home-comments/home-comments.component';

const routes: Route[] = [
  {path: '', redirectTo: '/home/user', pathMatch: 'full'},
  {path: 'login', component: LoginComponent, canActivate: [AuthGuard]},
  {path: 'home', component: HomeComponent, canActivate: [RandomGuard],
    children : [
      {path: '', redirectTo: 'user', pathMatch: 'full'},
      {path: 'user', component: HomeUserComponent},
      {path: 'accomodation', component: HomeAccomodationComponent},
      {path: 'comments', component: HomeCommentsComponent},
      {path: '**', redirectTo: 'user', pathMatch: 'full'},
    ]
  },
  {path: '**', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
