import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/User';
import { tap,mapTo,catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import * as jwt_decode from 'jwt-decode';

@Injectable({
    providedIn : 'root',
})
export class AuthService{

    constructor(private http : HttpClient){

    }

    login(user : User) : Observable<boolean>{
        return this.http.post<any>("api/login", {username: user.username, password: user.password})
        .pipe(
          tap(response => this.loginRequest(response)),
          mapTo(true),
          catchError(error => {
            return of(false);
          }));
    }

    loginRequest(response){
        localStorage.setItem("JWT_TOKEN", response.jwt);
        this.http.get('api/syncAll').subscribe(
            data =>{
              console.log(data);
            },
            error =>{
              console.log(error);
            }
          )
    }

    logout(){
        localStorage.removeItem("JWT_TOKEN");
    }

    isLogged() : boolean{
        let jwt = localStorage.getItem("JWT_TOKEN");
        if(jwt == null) return false;
        else if(!this.isTokenExpired()) return true;
    }

    isTokenExpired(token?: string): boolean {
        if(!token) token = this.getJwt();
        if(!token) return true;
    
        const date = this.getTokenExpirationDate(token);
        if(date === undefined) return false;
        return !(date.valueOf() > new Date().valueOf());
    }

    getJwt() : string{
        return localStorage.getItem("JWT_TOKEN");
    }

    getTokenExpirationDate(token: string): Date {
        const decoded = jwt_decode(token);
    
        if (decoded.exp === undefined) return null;
    
        const date = new Date(0); 
        date.setUTCSeconds(decoded.exp);
        return date;
    }
}