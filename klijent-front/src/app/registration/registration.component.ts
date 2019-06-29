import { Component, OnInit } from '@angular/core';
import { UseExistingWebDriver } from 'protractor/built/driverProviders';
import { User } from '../model/User';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import * as $ from 'jquery';

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
    let check : boolean = false;

    if(this.user.name == ""){
      $("#name").addClass('border-danger');
      check = true;
    } else {
      $("#name").removeClass('border-danger');
    }

    if(this.user.surname == ""){
      $("#surname").addClass('border-danger');
      check = true;
    } else {
      $("#surname").removeClass('border-danger');
    }

    if(this.user.username == ""){
      $("#username").addClass('border-danger');
      check = true;
    } else {
      $("#username").removeClass('border-danger');
    }

    if(this.user.email == ""){
      $("#email").addClass('border-danger');
      check = true;
    } else {
      $("#email").removeClass('border-danger');
    }

    if(this.user.password == ""){
      $("#password").addClass('border-danger');
      check = true;
    } else {
      $("#password").removeClass('border-danger');
    }

    if(!check){
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

}
