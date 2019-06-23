import { Component, OnInit } from '@angular/core';
import { AccommodationUnitService } from '../service/accommodationUnitService';
import { Accommodation } from '../model/Accommodation';

@Component({
  selector: 'app-home-logged-in-acc',
  templateUrl: './home-logged-in-acc.component.html',
  styleUrls: ['./home-logged-in-acc.component.css']
})
export class HomeLoggedInAccComponent implements OnInit {

  accommodations : Accommodation[] = [];
  searchAccommodation : Accommodation;
  nameLocation : String;
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
