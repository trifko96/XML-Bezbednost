import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reservation } from '../model/ReservationDTO';

@Injectable({
    providedIn : 'root',
})
export class ReservationService{

    constructor(private http : HttpClient) {}

    getReservations(){
        return this.http.get<Reservation[]>("api/reservation/res/getReservations");
    }

    cancelReservation(r : Reservation){
        return this.http.post<Reservation[]>("api/reservation/res/cancelReservation", r);
    }

    newReservation(r : Reservation){
        return this.http.post<Reservation[]>("api/reservation/res/newReservation", r);
    }
}