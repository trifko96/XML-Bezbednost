import { Component, OnInit } from '@angular/core';
import { Accommodation } from '../model/AccommodationDTO';
import { AccommodationUnitService } from '../service/accommodationUnitService';
import { AccommodationService } from '../model/AccommodationService';
import { AccommodationType } from '../model/AccommodationType';
import { ReservationService } from '../service/reservationService';
import { PriceDTO } from '../model/PriceDTO';
import { ImageService } from '../service/imageService';
import { PriceService } from '../service/priceService';

@Component({
  selector: 'app-home-accommodation',
  templateUrl: './home-accommodation.component.html',
  styleUrls: ['./home-accommodation.component.css']
})
export class HomeAccommodationComponent implements OnInit {

  accommodations : Accommodation[] = [];
  searchAccommodation : Accommodation = new Accommodation();
  nameLocation : string;
  accommodationServices : AccommodationService[] = [];
  accommodationTypes : AccommodationType[] = [];
  showSearch : boolean = false;
  showImages : boolean = false;
  images : String[] = [];
  showPrice: boolean = false;
  price : PriceDTO[] = [];
  reserveMessagge : string = "";
  dates : Date[] = [];
  selectedType : AccommodationType;
  selectedCategory : number = 0;

  constructor(private service : AccommodationUnitService, private resService : ReservationService, private imageService : ImageService, private priceService : PriceService) { 
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


  onSearch(){
    this.showSearch = true;
  }

  onSearch1(){
    this.searchAccommodation.accommodationType = this.selectedType;
    this.searchAccommodation.category = this.selectedCategory;
    this.searchAccommodation.fromDate = this.dates[0];
    this.searchAccommodation.toDate = this.dates[1];
    this.searchAccommodation.location.name = this.nameLocation;
    for(let s of this.accommodationServices){
      if(s.isChecked){
        this.searchAccommodation.accommodationService.push(s);
      }
    }

    this.service.searchAccommodations(this.searchAccommodation).subscribe(
      data => {
        this.accommodations = data;
        this.showSearch = false;
        this.searchAccommodation.capacity = 0;
        this.nameLocation = "";
        this.dates = [];
        this.selectedType.name = "";
        this.selectedCategory = 0;
      }
    )
  }

  onClick1(a : Accommodation){
    this.showImages = true;
    this.imageService.getImagesIdsByAccomodationUnit(a).subscribe(
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

  onClick(a : Accommodation){
    
    this.priceService.getPriceByUnit(a.accommodationId).subscribe(
      data => {
        this.showPrice = true;
        this.price = data;
      }
    )
  }

  hide(){
    this.showPrice = false;
  }

  onClick2(){
    this.reserveMessagge = "You must log in or register!"
  }

  onBack(){
    this.service.getAccommodations().subscribe(
      data => {
        this.accommodations = data;
      }
    )
  }

}
