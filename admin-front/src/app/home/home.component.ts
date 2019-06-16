import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  paths = [
    {path: "user", label: "Users"},
    {path: "comments", label: "Comments"},
    {path: "accomodation", label: "Accomodation"}
  ]

  constructor() { }

  ngOnInit() {
  }

}
