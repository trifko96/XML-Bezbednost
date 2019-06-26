import { Component, OnInit } from '@angular/core';
import { MessaggeDTO } from '../model/MessaggeDTO';
import { MessaggeService } from '../service/MessaggeService';

@Component({
  selector: 'app-home-messagges',
  templateUrl: './home-messagges.component.html',
  styleUrls: ['./home-messagges.component.css']
})
export class HomeMessaggesComponent implements OnInit {

  receivedMessagges: MessaggeDTO[] = [];
  sendMessagge: MessaggeDTO = new MessaggeDTO();
  showForm: boolean = false;

  constructor(private service : MessaggeService) {
    this.service.getReceivedMessagges().subscribe(
      data =>{
        this.receivedMessagges = data;
      }
    )
   }

  ngOnInit() {
  }

  onClick(messagge : MessaggeDTO){
    this.sendMessagge.agentName = messagge.agentName;
    this.sendMessagge.userName = messagge.userName;
    this.showForm = true;
  }

  onSend(){
    this.service.newMessagge(this.sendMessagge).subscribe(
      data => {
        this.showForm = false;
      }
    )
  }

}
