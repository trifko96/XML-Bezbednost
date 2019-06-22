import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../service/AccommodationService';
import { AccommodationUnit } from '../model/AccommodationUnit';
import { AccommodationServices } from '../model/AccommodationServices';
import { ImageService } from '../service/ImageService';

@Component({
  selector: 'app-home-acc-details',
  templateUrl: './home-acc-details.component.html',
  styleUrls: ['./home-acc-details.component.css']
})
export class HomeAccDetailsComponent implements OnInit {

  accUnits : AccommodationUnit[] = [];
  showService : boolean = false;
  showImages : boolean = false;
  accServices : AccommodationServices[] = [];
  images : String[] = [];

  constructor(private service : AccommodationService, private imageService : ImageService) {

    this.service.getAccommodationUnits().subscribe(
      data => {
        this.accUnits = data;
      }
    )
  }

  ngOnInit() {
  }

  onClick(unit : AccommodationUnit){
    this.showService = true;
    this.service.getServicesByUnit(unit).subscribe(
      data => {
        this.accServices = data;
      }
    )
  }

  onHide(){
    this.showService = false;
  }

  onClick1(unit : AccommodationUnit){
    this.showImages = true;
    this.images = [];
    this.imageService.getImagesIdsByAccomodationUnit(unit).subscribe(
      data => {
        for(let id of data){
          this.imageService.getImage(id).subscribe(
            data =>{
              let reader = new FileReader();
              reader.addEventListener("load", () => {
              this.images.push(reader.result as string);
            }, false);
            reader.readAsDataURL(data);
          }
        )
      }
    });
  }

  onClick2(unit : AccommodationUnit){
    this.service.reserveAccUnit(unit).subscribe(
      data => {
        this.accUnits = data;
      }
    )
  }

}
