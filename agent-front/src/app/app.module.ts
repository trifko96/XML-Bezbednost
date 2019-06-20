import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthGuard } from './guards/AuthGuard';
import { RandomGuard } from './guards/RandomGuard';
import { AuthInterceptor } from './http-interceptor/interceptor';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthService } from './service/AuthService';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { HomeAccDetailsComponent } from './home-acc-details/home-acc-details.component';
import { HomeNewaccComponent } from './home-newacc/home-newacc.component';
import { HomePriceComponent } from './home-price/home-price.component';
import { HomeReservationsComponent } from './home-reservations/home-reservations.component';
import { HomeMessaggesComponent } from './home-messagges/home-messagges.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HomeAccDetailsComponent,
    HomeNewaccComponent,
    HomePriceComponent,
    HomeReservationsComponent,
    HomeMessaggesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BsDatepickerModule.forRoot(),
    HttpClientModule,
  ],
  providers: [
    AuthService,
    AuthGuard,
    RandomGuard,
    { provide : HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi : true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
