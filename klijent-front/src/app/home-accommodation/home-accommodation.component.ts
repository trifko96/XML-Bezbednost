import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/AccommodationDTO';
import { AccommodationUnitService } from '../service/accommodationUnitService';
import { AccommodationService } from '../model/AccommodationService';
import { AccommodationType } from '../model/AccommodationType';
import { ReservationService } from '../service/reservationService';
import { PriceDTO } from '../model/PriceDTO';
import { ImageService } from '../service/imageService';
import { PriceService } from '../service/priceService';

@Component({
  selector: 'app-home-accommodation',
  templateUrl: './home-accommodation.component.html',
  styleUrls: ['./home-accommodation.component.css']
})
export class HomeAccommodationComponent implements OnInit {

  accommodations : Accommodation[] = [];
  searchAccommodation : Accommodation;
  nameLoation : string;
  distance : number;
  accommodationServices : AccommodationService[] = [];
  accommodationTypes : AccommodationType[] = [];
  showSearch : boolean = false;
  showImages : boolean = false;
  images : String[] = [];
  showPrice: boolean = false;
  price : PriceDTO[] = [];
  reserveMessagge : string = "";

  constructor(private service : AccommodationUnitService, private resService : ReservationService, private imageService : ImageService, private priceService : PriceService) { 
    this.service.getAccommodations().subscribe(
      data => {
        this.accommodations = data;
      }
    )

    this.service.getAccommodationTypes().subscribe(
      data => {
        this.accommodationTypes = data;
      }
    )

    this.service.getAccommodationServices().subscribe(
      data => {
        this.accommodationServices = data;
      }
    )
  }

  ngOnInit() {
  }


  onSearch(){
    this.showSearch = true;
  }

  onSearch1(){
    this.showSearch = false;
  }

  onClick1(a : Accommodation){
    this.showImages = true;
    this.imageService.getImagesIdsByAccomodationUnit(a).subscribe(
      data => {
        for(let id of data){
          this.imageService.getImage(id).subscribe(
            data =>{
              let reader = new FileReader();
              reader.addEventListener("load", () => {
              this.images.push(reader.result as string);
            }, false);
            reader.readAsDataURL(data);
          }
        )
      }
    });
  }

  onClick(a : Accommodation){
    
    this.priceService.getPriceByUnit(a.accommodationId).subscribe(
      data => {
        this.showPrice = true;
        this.price = data;
      }
    )
  }

  hide(){
    this.showPrice = false;
  }

  onClick2(){
    this.reserveMessagge = "You must log in or register!"
  }

}
