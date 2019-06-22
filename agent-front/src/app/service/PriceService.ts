import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PriceDTO } from '../model/PriceDTO';

@Injectable({
    providedIn : 'root',
})
export class PriceService{

    constructor(private http : HttpClient) {}

    getPriceByUnit(id : number){
        return this.http.post<PriceDTO[]>("api/price/getPrice", id);
    }

    addNewPrice(p : PriceDTO){
        return this.http.post("api/price/addNewPrice", p);
    }
}