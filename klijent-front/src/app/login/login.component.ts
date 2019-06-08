import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message : string

  constructor(private http: HttpClient) { 
    this.http.get<string>("api/user-service/getResponse").subscribe(
      data=>{
        this.message = data;
      }
    );
  }

  ngOnInit() {
  }

}
