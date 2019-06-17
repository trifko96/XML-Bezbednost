import { Component, OnInit } from '@angular/core';
import { UseExistingWebDriver } from 'protractor/built/driverProviders';
import { User } from '../model/User';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user : User = new User();
  messagge : String;
  constructor(private http : HttpClient, private router : Router) { }

  
  ngOnInit() {
  }

  submit(){
    this.http.post<User>("api/auth/User/registration", this.user).subscribe(
      data=>{
        this.router.navigate(["/login"]);
      },

      error=>{
        this.messagge = "error";
      }
      

    );
  }

}
