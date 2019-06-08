import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  messagge : string;

  constructor(private http: HttpClient) {
      this.http.get<string>("api/user-service/getResponse").subscribe(
        data => { 
          console.log(data);
          this.messagge = data;
        }
      );
      
   }

  ngOnInit() {
  }

}
