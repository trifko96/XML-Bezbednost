import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { AuthService } from './service/AuthService';
import { FormsModule } from '@angular/forms';
import { AuthGuard } from './guards/AuthGuard';
import { RandomGuard } from './guards/RandomGuard';
import { AuthInterceptor } from './http-interceptor/interceptor';
import { HomeUserComponent } from './home-user/home-user.component';
import { HomeAccomodationComponent } from './home-accomodation/home-accomodation.component';
import { HomeCommentsComponent } from './home-comments/home-comments.component';
import { HomeUserService } from './service/HomeUserService';
import { AccomodationService } from './service/AccomodationService';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HomeUserComponent,
    HomeAccomodationComponent,
    HomeCommentsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    AuthService,
    AuthGuard,
    RandomGuard,
    HomeUserService,
    AccomodationService,
    { provide : HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi : true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
