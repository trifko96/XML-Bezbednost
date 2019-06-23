import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Accommodation } from '../model/Accommodation';

@Injectable({
    providedIn : 'root',
})
export class AccommodationUnitService {

    constructor(private http : HttpClient) {}

    getAccommodations(){
        return this.http.get<Accommodation[]>("api/acc/getAccommodations");
    }

}