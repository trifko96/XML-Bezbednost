import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AccommodationUnit } from '../model/AccommodationUnit';

@Injectable({
    providedIn : 'root',
})
export class ImageService {

    constructor(private http : HttpClient){

    }

    uploadImages(fd : FormData){
        return this.http.post('api/uploadImages',fd).subscribe();
     }

     getImagesIdsByAccomodationUnit(accUnit : AccommodationUnit){
        return this.http.post<number[]>("api/getImageIds", accUnit);
     }
  
     getImage(id : number){
        return this.http.post("api/getImage", id, {responseType: 'blob'});
     }
}