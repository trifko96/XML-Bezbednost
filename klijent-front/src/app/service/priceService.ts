import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PriceDTO } from '../model/PriceDTO';

@Injectable({
    providedIn : 'root',
})
export class PriceService{

    constructor(private http : HttpClient) {}

    getPriceByUnit(id : number){
        return this.http.post<PriceDTO[]>("api/accomodation/price/getPrice", id);
    }
}