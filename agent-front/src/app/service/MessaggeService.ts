import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MessaggeDTO } from '../model/MessaggeDTO';

@Injectable({
    providedIn : 'root',
})
export class MessaggeService{

    constructor(private http : HttpClient) {}

    getReceivedMessagges(){
        return this.http.get<MessaggeDTO[]>("api/mess/getReceivedMessagges");
    }

    newMessagge(m : MessaggeDTO){
        return this.http.post<MessaggeDTO[]>("api/mess/newMessagge",m);
    }
}