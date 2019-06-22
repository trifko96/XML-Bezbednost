import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reservation } from '../model/ReservationDTO';

@Injectable({
    providedIn : 'root',
})
export class ReservationService{

    constructor(private http : HttpClient) {}

    getReservations(){
        return this.http.get<Reservation[]>("api/res/getReservations");
    }

    approveReservation(r : Reservation){
        return this.http.post<Reservation[]>("api/res/approveRes",r);
    }

    rejectReservation(r : Reservation){
        return this.http.post<Reservation[]>("api/res/rejectRes",r);
    }
}