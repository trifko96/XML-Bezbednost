import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccommodationUnit } from '../model/AccommodationUnit';
import { AccommodationServices } from '../model/AccommodationServices';
import { AccommodationType } from '../model/AccommodationType';

@Injectable({
    providedIn : 'root',
})
export class AccommodationService {

    constructor(private http : HttpClient) {}

    addNewAccommodationUnit(acc : AccommodationUnit){
        return this.http.post<any>("api/acc/addNewAcc", acc);
    }

    getAccommodationUnits(){
        return this.http.get<AccommodationUnit[]>("api/acc/getAllUnits");
    }

    getAccommodationServices(){
        return this.http.get<AccommodationServices[]>("api/acc/getAllServices");
    }

    getAccommodationTypes(){
        return this.http.get<AccommodationType[]>("api/acc/getAllTypes");
    }

}