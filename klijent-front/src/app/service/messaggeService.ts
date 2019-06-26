import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MessaggeDTO } from '../model/MessaggeDTO';

@Injectable({
    providedIn : 'root',
})
export class MessaggeService {

    constructor(private http : HttpClient) {}

    getSentMessagges(){
        return this.http.get<MessaggeDTO[]>("api/messagge/mess/getSentMessagges");
    }

    getReceivedMessagges(){
        return this.http.get<MessaggeDTO[]>("api/messagge/mess/getReceivedMessagges");
    }

    newMessage(m : MessaggeDTO){
        return this.http.post<MessaggeDTO[]>("api/messagge/mess/newMessagge",m);
    }

}