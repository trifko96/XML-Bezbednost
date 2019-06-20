import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-price',
  templateUrl: './home-price.component.html',
  styleUrls: ['./home-price.component.css']
})
export class HomePriceComponent implements OnInit {

  isClicked : boolean = false;
  isSubmit : boolean = false;
  isPressed : boolean = false;

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
    this.isSubmit = !this.isSubmit;
    this.isClicked = !this.isClicked;
    this.isPressed = false;
  }

}
