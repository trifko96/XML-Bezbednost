import { Component, OnInit } from '@angular/core';
import { MessaggeDTO } from '../model/MessaggeDTO';
import { MessaggeService } from '../service/messaggeService';

@Component({
  selector: 'app-home-logged-in-messagge',
  templateUrl: './home-logged-in-messagge.component.html',
  styleUrls: ['./home-logged-in-messagge.component.css']
})
export class HomeLoggedInMessaggeComponent implements OnInit {

  sentMessagges : MessaggeDTO[] = [];
  receivedMessagges : MessaggeDTO[] = [];

  constructor(private service : MessaggeService) {
    this.service.getSentMessagges().subscribe(
      data =>{
        this.sentMessagges = data;
      }
    )

    this.service.getReceivedMessagges().subscribe(
      data =>{
        this.receivedMessagges = data;
      }
    )
   }

  ngOnInit() {
  }

}
