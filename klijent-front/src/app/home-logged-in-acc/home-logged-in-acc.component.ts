import { Component, OnInit } from '@angular/core';
import { AccommodationUnitService } from '../service/accommodationUnitService';
import { Accommodation } from '../model/AccommodationDTO';
import { AccommodationService } from '../model/AccommodationService';
import { AccommodationType } from '../model/AccommodationType';
import { Reservation } from '../model/ReservationDTO';
import { ReservationService } from '../service/reservationService';
import { ImageService } from '../service/imageService';
import { PriceService } from '../service/priceService';
import { PriceDTO } from '../model/PriceDTO';

@Component({
  selector: 'app-home-logged-in-acc',
  templateUrl: './home-logged-in-acc.component.html',
  styleUrls: ['./home-logged-in-acc.component.css']
})
export class HomeLoggedInAccComponent implements OnInit {

  accommodations : Accommodation[] = [];
  searchAccommodation : Accommodation = new Accommodation();
  nameLocation : string;
  distance : number;
  accommodationServices : AccommodationService[] = [];
  accommodationTypes : AccommodationType[] = [];
  reservation : Reservation = new Reservation();
  dates : Date[] = [];
  showForm : boolean = false;
  showSearch : boolean = false;
  showImages : boolean = false;
  images : String[] = [];
  showPrice: boolean = false;
  price : PriceDTO[] = [];


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

  onClick2(acc : Accommodation){
    this.reservation.accommodationId = acc.accommodationId;
    this.reservation.accommodationName = acc.name;
    this.showForm = true;
  }

  onSend(){
    this.reservation.fromDate = this.dates[0];
    this.reservation.toDate = this.dates[1];
    this.resService.newReservation(this.reservation).subscribe(
      data => {
        this.showForm = false;
      }
    )
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

}
