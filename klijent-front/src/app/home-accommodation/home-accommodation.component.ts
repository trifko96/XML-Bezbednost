import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/Accommodation';
import { AccommodationUnitService } from '../service/accommodationUnitService';

@Component({
  selector: 'app-home-accommodation',
  templateUrl: './home-accommodation.component.html',
  styleUrls: ['./home-accommodation.component.css']
})
export class HomeAccommodationComponent implements OnInit {

  accommodations : Accommodation[] = [];
  searchAccommodation : Accommodation;
  nameLoation : String;
  distance : number;

  constructor(private service : AccommodationUnitService) { 
    this.service.getAccommodations().subscribe(
      data => {
        this.accommodations = data;
      }
    )
  }

  ngOnInit() {
  }

}
