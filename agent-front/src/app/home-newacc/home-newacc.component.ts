import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../service/AccommodationService';
import { AccommodationServices } from '../model/AccommodationServices';
import { AccommodationType } from '../model/AccommodationType';

@Component({
  selector: 'app-home-newacc',
  templateUrl: './home-newacc.component.html',
  styleUrls: ['./home-newacc.component.css']
})
export class HomeNewaccComponent implements OnInit {

  services : AccommodationServices[] = [];
  types : AccommodationType[] = [];

  constructor(private service : AccommodationService) { 
    this.service.getAccommodationTypes().subscribe(
      data => {
        this.types = data;
      }
    )

    this.service.getAccommodationServices().subscribe(
      data => {
        this.services = data;
      }
    )
  }

  

  ngOnInit() {
  }

}
