import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Accommodation } from '../model/Accommodation';
import { AccommodationService } from '../model/AccommodationService';
import { AccommodationType } from '../model/AccommodationType';

@Injectable({
    providedIn : 'root',
})
export class AccommodationUnitService {

    constructor(private http : HttpClient) {}

    getAccommodations(){
        return this.http.get<Accommodation[]>("api/acc/getAccommodations");
    }

    getAccommodationServices(){
        return this.http.get<AccommodationService[]>("api/accService/getServices");
    }

    getAccommodationTypes(){
        return this.http.get<AccommodationType[]>("api/accType/getTypes");
    }




    
}