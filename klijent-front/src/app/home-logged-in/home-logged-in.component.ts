import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { authService } from '../service/authService';

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

  constructor(private service : authService, private router : Router) { }

  ngOnInit() {
  }

  logout(){
    this.service.logout();
    this.router.navigate(["/home"]); 
  }

}
