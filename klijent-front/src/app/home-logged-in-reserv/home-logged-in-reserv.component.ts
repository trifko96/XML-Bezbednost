import { Component, OnInit } from '@angular/core';
import { Reservation } from '../model/ReservationDTO';
import { ReservationService } from '../service/reservationService';
import { MessaggeDTO } from '../model/MessaggeDTO';
import { MessaggeService } from '../service/messaggeService';

@Component({
  selector: 'app-home-logged-in-reserv',
  templateUrl: './home-logged-in-reserv.component.html',
  styleUrls: ['./home-logged-in-reserv.component.css']
})
export class HomeLoggedInReservComponent implements OnInit {

  reservations : Reservation[] = [];
  showMessagge : boolean = false;
  sendMessagge : MessaggeDTO = new MessaggeDTO();
  alert : string = "";

  constructor(private service : ReservationService, private mService : MessaggeService) {
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
    this.sendMessagge.accommodationName = r.accommodationName;
  }

  onSend(){
    this.mService.newMessage(this.sendMessagge).subscribe(
      data => {
        this.showMessagge = false;
      },
      error => {
        this.alert = "Your messagge is not sent!";
      }
    )
    
  }

}
