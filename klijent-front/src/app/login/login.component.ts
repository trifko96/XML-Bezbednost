import { Component, OnInit } from '@angular/core';
import { authService } from '../service/authService';
import { Router } from '@angular/router';
import { User } from '../model/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user : User = new User();
  messagge : string;

  constructor(private auth : authService, private router : Router) { 
}

 onClick(){
   this.auth.login(this.user).subscribe(
     data => {
       if(data) {  
         this.router.navigate(["/homeLogged"]);
       } else {
         this.messagge = "error";
       } 
     }
   );
 }

  ngOnInit() {
  }

}
