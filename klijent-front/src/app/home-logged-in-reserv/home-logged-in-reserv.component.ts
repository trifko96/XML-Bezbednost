import { Component, OnInit } from '@angular/core';
import { Reservation } from '../model/ReservationDTO';
import { ReservationService } from '../service/reservationService';

@Component({
  selector: 'app-home-logged-in-reserv',
  templateUrl: './home-logged-in-reserv.component.html',
  styleUrls: ['./home-logged-in-reserv.component.css']
})
export class HomeLoggedInReservComponent implements OnInit {

  reservations : Reservation[] = [];
  showMessagge : boolean = false;

  constructor(private service : ReservationService) {
    this.service.getReservations().subscribe(
      data => {
        this.reservations = data;
      }
    )
   }

  ngOnInit() {
  }

  onClick1(r : Reservation){
    this.service.cancelReservation(r).subscribe(
      data =>{
        this.reservations = data;
      }
    )
  }

  onClick(r : Reservation){
    this.showMessagge = true;
  }

  onSend(){
    this.showMessagge = false;
  }

}
