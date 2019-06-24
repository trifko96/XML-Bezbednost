import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/Accommodation';
import { AccommodationUnitService } from '../service/accommodationUnitService';
import { AccommodationService } from '../model/AccommodationService';
import { AccommodationType } from '../model/AccommodationType';

@Component({
  selector: 'app-home-accommodation',
  templateUrl: './home-accommodation.component.html',
  styleUrls: ['./home-accommodation.component.css']
})
export class HomeAccommodationComponent implements OnInit {

  accommodations : Accommodation[] = [];
  searchAccommodation : Accommodation;
  nameLoation : string;
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
