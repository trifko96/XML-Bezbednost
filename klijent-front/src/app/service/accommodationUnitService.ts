import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Accommodation } from '../model/AccommodationDTO';
import { AccommodationService } from '../model/AccommodationService';
import { AccommodationType } from '../model/AccommodationType';

@Injectable({
    providedIn : 'root',
})
export class AccommodationUnitService {

    constructor(private http : HttpClient) {}

    getAccommodations(){
        return this.http.get<Accommodation[]>("api/accomodation/acc/all/getAccommodations");
    }

    getAccommodationServices(){
        return this.http.get<AccommodationService[]>("api/accomodation/accService/all/getServices");
    }

    getAccommodationTypes(){
        return this.http.get<AccommodationType[]>("api/accomodation/accType/all/getTypes");
    }

    searchAccommodations(a : Accommodation){
        return this.http.post<Accommodation[]>("api/accomodation/acc/all/searchAcc", a);
    }


    
}