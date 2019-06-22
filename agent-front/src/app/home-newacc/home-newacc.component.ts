import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../service/AccommodationService';
import { AccommodationServices } from '../model/AccommodationServices';
import { AccommodationType } from '../model/AccommodationType';
import { HttpClient } from '@angular/common/http';
import { AccommodationUnit } from '../model/AccommodationUnit';
import { ImageService } from '../service/ImageService';
import * as $ from 'jquery';
declare var ol: any;

@Component({
  selector: 'app-home-newacc',
  templateUrl: './home-newacc.component.html',
  styleUrls: ['./home-newacc.component.css']
})
export class HomeNewaccComponent implements OnInit {

  services : AccommodationServices[] = [];
  types : AccommodationType[] = [];
  map : any;
  accUnit : AccommodationUnit = new AccommodationUnit();
  selectedFiles : any[];
  messagge : string = "Select images";
  selectedType : AccommodationType;
  selectedCategory : number = 0;
  error : string = "";
  errorLoc : string = "";
  errorInput : string = "";

  constructor(private service : AccommodationService, private http : HttpClient, private imageService : ImageService) { 
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
    this.initilizeMap();
  }

  initilizeMap(){
    this.map = new ol.Map({
      target: 'map',
      layers: [
        new ol.layer.Tile({
          source: new ol.source.OSM()
        })
      ],
      view: new ol.View({
        center: ol.proj.fromLonLat([20, 45]),
        zoom: 8
      })
    });

    this.map.on('click', (event) => {
  		event.preventDefault();
  	
      var coord = ol.proj.toLonLat(event.coordinate); 
      this.setMarker(coord);

      this.http.get<any>('map/reverse?format=json&lon=' + coord[0] + '&lat=' + coord[1]).subscribe(
        data =>{
          this.accUnit.location.name = data.display_name;
          this.accUnit.location.lattitude = data.lat;
          this.accUnit.location.longitude = data.lon;
        })
  	});
  }

  setMarker(coords){

    var layersToRemove = [];
    this.map.getLayers().forEach(function (layer) {
        if (layer.get('name') != undefined && layer.get('name') === 'markerVector') {
            layersToRemove.push(layer);
        }
    });

    var len = layersToRemove.length;
    for(var i = 0; i < len; i++) {
        this.map.removeLayer(layersToRemove[i]);
    }

    var marker = new ol.Feature({
        geometry: new ol.geom.Point(ol.proj.transform(coords, 'EPSG:4326', 'EPSG:3857')),
    });

    var markers = new ol.source.Vector({
        features: [marker]
    });

    var markerVectorLayer = new ol.layer.Vector({
        source: markers,
    });
    this.map.addLayer(markerVectorLayer);
    markerVectorLayer.set('name','markerVector');
  }

  onChoose(event){
    this.selectedFiles = event.target.files;

    if(this.selectedFiles.length == 0){
      this.messagge = "Select images";
    }else{
      this.messagge = "";
    
      for(let file of this.selectedFiles){
        this.messagge = this.messagge + file.name +", ";
      }
    }
  }

  uploadImages(accUnitId){
      let fd = new FormData();
      for ( let file of this.selectedFiles){
        fd.append('file', file);
      }
      fd.append('accId', accUnitId);
      this.imageService.uploadImages(fd);
  }

  onClick(){
    let check : boolean = false;

    if(this.accUnit.name == ""){
      $("#nameAcc").addClass('border-danger');
      check = true;
    } else {
      $("#nameAcc").removeClass('border-danger');
    }

    if(this.accUnit.description == ""){
      $("#descAcc").addClass('border-danger');
      check = true;
    } else {
      $("#descAcc").removeClass('border-danger');
    }

    if(this.accUnit.capacity == null || this.accUnit.capacity < 1){
      $("#capAcc").addClass('border-danger');
      check = true;
    } else {
      $("#capAcc").removeClass('border-danger');
    }

    if(this.accUnit.cancelingPeriod == null || this.accUnit.cancelingPeriod < 0){
      $("#canAcc").addClass('border-danger');
      check = true;
    } else {
      $("#canAcc").removeClass('border-danger');
    }

    if(this.selectedCategory == 0){
      $("#catAcc").addClass('border-danger');
      check = true;
    } else {
      $("#catAcc").removeClass('border-danger');
    }

    if(this.accUnit.location.name == "Location"){
      this.errorLoc = "Select location!";
      check = true;
    } else {
      this.errorLoc = "";
    }

    if(this.messagge == "Select images"){
      this.error = "Select images!";
      check = true;
    } else {
      this.error = "";
    }

    if(!check){
      for(let s of this.services){
        if(s.isChecked){
          this.accUnit.accommodationService.push(s);
        }
      }
      this.accUnit.category = this.selectedCategory.toString();
      this.accUnit.accommodationType = this.selectedType;
      this.service.addNewAccommodationUnit(this.accUnit).subscribe(
        data => {
          this.uploadImages(data.accommodationId);
          this.service.getAccommodationServices().subscribe(
            data => {
              this.services = data;
            }
          )
          this.selectedCategory = 0;
          this.service.getAccommodationTypes().subscribe(
            data => {
              this.types = data;
            }
          )
          this.messagge = "Select images";
          this.accUnit = new AccommodationUnit();
        }
      )
    } else {
        this.errorInput = "Fill required fields!";
    }
  }

}
