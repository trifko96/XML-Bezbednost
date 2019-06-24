import { Component, OnInit } from '@angular/core';
import { AccommodationUnitService } from '../service/accommodationUnitService';
import { Accommodation } from '../model/Accommodation';
import { AccommodationService } from '../model/AccommodationService';
import { AccommodationType } from '../model/AccommodationType';
import { Reservation } from '../model/ReservationDTO';
import { ReservationService } from '../service/reservationService';

@Component({
  selector: 'app-home-logged-in-acc',
  templateUrl: './home-logged-in-acc.component.html',
  styleUrls: ['./home-logged-in-acc.component.css']
})
export class HomeLoggedInAccComponent implements OnInit {

  accommodations : Accommodation[] = [];
  searchAccommodation : Accommodation;
  nameLocation : string;
  distance : number;
  accommodationServices : AccommodationService[] = [];
  accommodationTypes : AccommodationType[] = [];
  reservation : Reservation;
  dates : Date[] = [];
  showForm : boolean = false;
  showSearch : boolean = false;


  constructor(private service : AccommodationUnitService, private resService : ReservationService) {
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

}
