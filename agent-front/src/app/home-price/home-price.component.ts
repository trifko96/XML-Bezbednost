import { Component, OnInit } from '@angular/core';
import { PriceService } from '../service/PriceService';
import { AccommodationUnit } from '../model/AccommodationUnit';
import { AccommodationService } from '../service/AccommodationService';
import { PriceDTO } from '../model/PriceDTO';

@Component({
  selector: 'app-home-price',
  templateUrl: './home-price.component.html',
  styleUrls: ['./home-price.component.css']
})
export class HomePriceComponent implements OnInit {

  isClicked : boolean = false;
  isSubmit : boolean = false;
  isPressed : boolean = false;
  isShowed : boolean = false;
  accUnits : AccommodationUnit[] = [];
  pricePlans : PriceDTO[] = [];
  pricePlan : PriceDTO = new PriceDTO();
  dates : Date[] = [];
  currentAcc : AccommodationUnit;
  messagge : string;

  constructor(private service : PriceService, private accService : AccommodationService) { 
    this.accService.getAccommodationUnits().subscribe(
      data => {
        this.accUnits = data;
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
    if(this.pricePlan.oneNightPrice <= 0 || this.dates.length != 2){
      this.messagge = "Fields incorrectly filled!"
    } else {
      this.pricePlan.fromDate = this.dates[0];
      this.pricePlan.toDate = this.dates[1];
      this.pricePlan.accId = this.currentAcc.accommodationId;
      this.service.addNewPrice(this.pricePlan).subscribe(
        data => {
          this.service.getPriceByUnit(this.currentAcc.accommodationId).subscribe(
            data => {
              this.pricePlans = data;
            }
          )
        }
      )
      this.isSubmit = !this.isSubmit;
      this.isClicked = !this.isClicked;
      this.isPressed = false;
    }
  }

  showPlans(a : AccommodationUnit){
    this.service.getPriceByUnit(a.accommodationId).subscribe(
      data => {
        this.pricePlans = data;
        this.isShowed = true;
        this.currentAcc = a;
      }
    )
  }

}
