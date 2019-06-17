import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-accomodation',
  templateUrl: './home-accomodation.component.html',
  styleUrls: ['./home-accomodation.component.css']
})
export class HomeAccomodationComponent implements OnInit {

  isClicked : boolean = false;
  isSubmit : boolean = false;
  isClicked1 : boolean = false;
  isSubmit1 : boolean = false;
  isPressed : boolean = false;
  isPressed1 : boolean = false;

  constructor() { }

  ngOnInit() {
  }

  onClick(){
    if(!this.isPressed){
      this.isClicked = !this.isClicked;
    }
    this.isSubmit = !this.isSubmit;
    this.isPressed = true;
  }

  onSubmit(){
    this.isClicked = !this.isClicked;
    this.isSubmit = !this.isSubmit;
    this.isPressed = false;
  }

  onClick1(){
    if(!this.isPressed1){
      this.isClicked1 = !this.isClicked1;
    }
    this.isSubmit1 = !this.isSubmit1;
    this.isPressed1 = true;
  }

  onSubmit1(){
    this.isClicked1 = !this.isClicked1;
    this.isSubmit1 = !this.isSubmit1;
    this.isPressed1 = false;
  }

}
