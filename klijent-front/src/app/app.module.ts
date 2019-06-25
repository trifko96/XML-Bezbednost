import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { AuthInterceptor } from './http-interceptor/interceptor';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import {authService} from './service/authService';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { HomeAccommodationComponent } from './home-accommodation/home-accommodation.component';
import { HomeLoggedInComponent } from './home-logged-in/home-logged-in.component';
import { HomeLoggedInAccComponent } from './home-logged-in-acc/home-logged-in-acc.component';
import { HomeLoggedInReservComponent } from './home-logged-in-reserv/home-logged-in-reserv.component';
import { AuthGuard } from './guards/AuthGuard';
import { RandomGuard } from './guards/RandomGuard';
import { ImageService } from './service/imageService';
import { PriceService } from './service/priceService';
import { ReservationService } from './service/reservationService';
import { AccommodationUnitService } from './service/accommodationUnitService';

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
    BsDatepickerModule.forRoot(),
    CarouselModule.forRoot(),
    FormsModule
  ],
  providers: [authService,
    AuthGuard,
    RandomGuard,
    ImageService,
    PriceService,
    ReservationService,
    AccommodationUnitService,
    { provide : HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi : true},
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
