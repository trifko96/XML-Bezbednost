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

  constructor() { }

  ngOnInit() {
  }

  onClick(){
    this.isClicked = !this.isClicked;
    this.isSubmit = !this.isSubmit;
  }

  onSubmit(){
    this.isClicked = !this.isClicked;
    this.isSubmit = !this.isSubmit;
  }

  onClick1(){
    this.isClicked1 = !this.isClicked1;
    this.isSubmit1 = !this.isSubmit1;
  }

  onSubmit1(){
    this.isClicked1 = !this.isClicked1;
    this.isSubmit1 = !this.isSubmit1;
  }

}
