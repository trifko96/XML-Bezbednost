import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Accommodation } from '../model/AccommodationDTO';

@Injectable({
    providedIn : 'root',
})
export class ImageService{

    constructor(private http : HttpClient) {}

    getImagesIdsByAccomodationUnit(accUnit : Accommodation){
        return this.http.post<number[]>("api/accomodation/image/getImageIds", accUnit);
     }
  
     getImage(id : number){
        return this.http.post("api/accomodation/image/getImage", id, {responseType: 'blob'});
     }
}