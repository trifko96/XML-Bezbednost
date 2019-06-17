import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/User';
import { Observable } from 'rxjs';
import { tap,mapTo,catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Injectable({
    providedIn : 'root',
})
export class authService{

    constructor(private http : HttpClient){

    }

    login(user : User) : Observable<boolean>{
        return this.http.post<any>("api/auth/login", {username: user.username, password: user.password})
        .pipe(
          tap(response => localStorage.setItem("JWT_TOKEN", response.jwt)),
          mapTo(true),
          catchError(error => {
            return of(false);
          }));
    }

    logout(){
        localStorage.removeItem("JWT_TOKEN");
    }
}