import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccomodationServiceModel } from '../model/AccomodationServiceModel';
import { AccomodationType } from '../model/AccomodationType';

@Injectable({
    providedIn : 'root',
})
export class AccomodationService {

    constructor(private http : HttpClient) {

    }

    addNewService(service : AccomodationServiceModel) {
        return this.http.post<AccomodationServiceModel[]>("api/accomodation/accService/admin/addNewAccService",service);
    }

    removeService(service : AccomodationServiceModel) {
        return this.http.post<AccomodationServiceModel[]>("api/accomodation/accService/admin/removeAccService",service);
    }

    addNewType(type : AccomodationType) {
        return this.http.post<AccomodationType[]>("api/accomodation/accType/admin/addNewAccType",type);
    }

    removeType(type : AccomodationType) {
        return this.http.post<AccomodationType[]>("api/accomodation/accType/admin/removeAccType",type);
    }

    getServices() {
        return this.http.get<AccomodationServiceModel[]>("api/accomodation/accService/all/getServices");
    }

    getTypes() {
        return this.http.get<AccomodationType[]>("api/accomodation/accType/all/getTypes");
    }
}