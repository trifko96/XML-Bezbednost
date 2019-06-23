import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-logged-in',
  templateUrl: './home-logged-in.component.html',
  styleUrls: ['./home-logged-in.component.css']
})
export class HomeLoggedInComponent implements OnInit {

  paths = [
    {path: "homeLoggedAcc", label: "Accomodations"},
    {path: "homeLoggedRes", label: "Reservations"}
  ]

  constructor() { }

  ngOnInit() {
  }

}
