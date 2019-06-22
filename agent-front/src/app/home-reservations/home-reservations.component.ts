import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../service/ReservationService';
import { Reservation } from '../model/ReservationDTO';

@Component({
  selector: 'app-home-reservations',
  templateUrl: './home-reservations.component.html',
  styleUrls: ['./home-reservations.component.css']
})
export class HomeReservationsComponent implements OnInit {

  reservations : Reservation[] = [];

  constructor(private service : ReservationService) {

    this.service.getReservations().subscribe(
      data => {
        this.reservations = data;
      }
    )

  }

  ngOnInit() {
  }

  approve(r : Reservation){
    this.service.approveReservation(r).subscribe(
      data => {
        this.reservations = data;
      }
    )
  }

  reject(r : Reservation){
    this.service.rejectReservation(r).subscribe(
      data => {
        this.reservations = data;
      }
    )
  }

}
