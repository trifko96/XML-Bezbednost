import { Component, OnInit } from '@angular/core';
import { AccomodationServiceModel } from '../model/AccomodationServiceModel';
import { AccomodationType } from '../model/AccomodationType';
import { AccomodationService } from '../service/AccomodationService';

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
  services : AccomodationServiceModel[] = [];
  types : AccomodationType[] = [];
  newService : AccomodationServiceModel = new AccomodationServiceModel();
  newType : AccomodationType = new AccomodationType();
  errorS : string;
  errorT : string;

  constructor(private service : AccomodationService) {
    this.service.getServices().subscribe(
      data => {
        this.services = data;
      }
    )

    this.service.getTypes().subscribe(
      data => {
        this.types = data;
      }
    )
  }

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
    this.service.addNewService(this.newService).subscribe(
      data => {
        this.services = data;
        this.isClicked = !this.isClicked;
        this.isSubmit = !this.isSubmit;
        this.isPressed = false;
      },
      error => {
        this.errorS = "Service with this name already exist";
      }
    )
  }

  onClick1(){
    if(!this.isPressed1){
      this.isClicked1 = !this.isClicked1;
    }
    this.isSubmit1 = !this.isSubmit1;
    this.isPressed1 = true;
  }

  onSubmit1(){
    this.service.addNewType(this.newType).subscribe(
      data => {
        this.types = data;
        this.isClicked1 = !this.isClicked1;
        this.isSubmit1 = !this.isSubmit1;
        this.isPressed1 = false;
      },
      error => {
        this.errorT = "Type with this name already exist";
      }
    )
  }

  deleteService(acc : AccomodationServiceModel){
    this.service.removeService(acc).subscribe(
      data => {
        this.services = data;
      }
    )
  }

  deleteType(acct : AccomodationType){
    this.service.removeType(acct).subscribe(
      data => {
        this.types = data;
      }
    )
  }

}
