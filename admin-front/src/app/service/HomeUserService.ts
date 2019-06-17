import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/User';

@Injectable({
    providedIn : 'root',
})
export class HomeUserService{

    constructor(private http : HttpClient){

    }

    addNewAgent(agent : User) {
        return this.http.post<User[]>("api/auth/admin/addNewAgent",agent);
    }

    activateUser(user : User) {
        return this.http.post<User[]>("api/auth/admin/activateUser",user);
    }

    blockUser(user : User) {
        return this.http.post<User[]>("api/auth/admin/blockUser",user);
    }

    removeUser(user : User) {
        return this.http.post<User[]>("api/auth/admin/removeUser",user);
    }

    getAgents() {
        return this.http.get<User[]>("api/auth/admin/getAgents");
    }

    getUsers() {
        return this.http.get<User[]>("api/auth/admin/getUsers");
    }
}