import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/AuthService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  paths = [
    {path: "accDetails", label: "Accommodation details"},
    {path: "newAcc", label: "New accommodation"},
    {path: "price", label: "Price plan"},
    {path: "reservations", label: "Reservations"},
    {path: "messagges", label: "Messagges"}
  ]

  constructor(private service : AuthService, private router : Router) { }

  ngOnInit() {
  }

  logout(){
    this.service.logout();
    this.router.navigate(["/login"]);    
  }

}
