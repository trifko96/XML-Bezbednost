import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import {authService} from './service/authService';
import { HomeAccommodationComponent } from './home-accommodation/home-accommodation.component';
import { HomeLoggedInComponent } from './home-logged-in/home-logged-in.component';
import { HomeLoggedInAccComponent } from './home-logged-in-acc/home-logged-in-acc.component';
import { HomeLoggedInReservComponent } from './home-logged-in-reserv/home-logged-in-reserv.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    HomeAccommodationComponent,
    HomeLoggedInComponent,
    HomeLoggedInAccComponent,
    HomeLoggedInReservComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [authService,],
  bootstrap: [AppComponent],
})
export class AppModule { }
