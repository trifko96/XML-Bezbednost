import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { Router } from '@angular/router';
import { AuthService } from '../service/AuthService';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user : User = new User();
  messagge : String;

  constructor(private auth : AuthService, private router : Router, private http : HttpClient) {
    this.http.get('api/acc/getUsers').subscribe(
      data =>{
        console.log(data);
      },
      error =>{
        console.log(error);
      }
    )
  }

  ngOnInit() {
  }

  onClick(){
    this.auth.login(this.user).subscribe(
      data => {
        if(data) {  
          this.router.navigate(["/home"]);
        } else {
          this.messagge = "error";
        }
      }
    );
  }

}
