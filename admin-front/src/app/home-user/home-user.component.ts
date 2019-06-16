import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-user',
  templateUrl: './home-user.component.html',
  styleUrls: ['./home-user.component.css']
})
export class HomeUserComponent implements OnInit {

  isClicked : boolean = false;
  isSubmit : boolean = false;

  constructor() { }

  ngOnInit() {
  }

  onClick(){
    this.isClicked = !this.isClicked;
    this.isSubmit = !this.isSubmit;
    
  }

  onSubmit(){
    this.isSubmit = !this.isSubmit;
    this.isClicked = !this.isClicked;
  }

}
