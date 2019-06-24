import { Component, OnInit } from '@angular/core';
import { AccommodationUnitService } from '../service/accommodationUnitService';
import { Accommodation } from '../model/Accommodation';
import { AccommodationService } from '../model/AccommodationService';
import { AccommodationType } from '../model/AccommodationType';

@Component({
  selector: 'app-home-logged-in-acc',
  templateUrl: './home-logged-in-acc.component.html',
  styleUrls: ['./home-logged-in-acc.component.css']
})
export class HomeLoggedInAccComponent implements OnInit {

  accommodations : Accommodation[] = [];
  searchAccommodation : Accommodation;
  nameLocation : string;
  distance : number;
  accommodationServices : AccommodationService[] = [];
  accommodationTypes : AccommodationType[] = [];


  constructor(private service : AccommodationUnitService) {
    this.service.getAccommodations().subscribe(
      data => {
        this.accommodations = data;
      }
    )

    this.service.getAccommodationTypes().subscribe(
      data => {
        this.accommodationTypes = data;
      }
    )

    this.service.getAccommodationServices().subscribe(
      data => {
        this.accommodationServices = data;
      }
    )
   }

  ngOnInit() {
  }

}
