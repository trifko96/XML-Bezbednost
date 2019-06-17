import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { HomeUserService } from '../service/HomeUserService';
import * as $ from 'jquery';

@Component({
  selector: 'app-home-user',
  templateUrl: './home-user.component.html',
  styleUrls: ['./home-user.component.css']
})
export class HomeUserComponent implements OnInit {

  isClicked : boolean = false;
  isSubmit : boolean = false;
  isPressed : boolean = false;
  agents : User[] = [];
  users : User[] = [];
  agent : User = new User();
  existAgent : string;
  messagge : string;

  constructor(private service : HomeUserService) {

    this.service.getUsers().subscribe(
      data => {
        this.users = data;
      }
    )

    this.service.getAgents().subscribe(
      data => {
        this.agents = data;
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
    let check : boolean = false;
    $(".form-control").each(function(){
      if($(this).val() == ""){
        $(this).addClass("border border-danger");
        check = true;
      } else {
        $(this).removeClass("border border-danger");
      }
    })
    if(!check){
      this.messagge = "";
      this.service.addNewAgent(this.agent).subscribe(
        data => {
          this.agents = data;
          this.isSubmit = !this.isSubmit;
          this.isClicked = !this.isClicked;
          this.isPressed = false;
          this.agent = new User();
          this.existAgent = "";
        },
        error => {
          this.existAgent = "Agent with this username or businessId already exist!"
        }
      )
    } else {
      this.messagge = "Fill required fields!";
    }
    
  }

  activate(user : User){
    this.service.activateUser(user).subscribe(
      data => {
        this.service.getUsers().subscribe(
          data => {
            this.users = data;
          }
        )
      }
    )
  }

  block(user : User){
    this.service.blockUser(user).subscribe(
      data => {
        this.service.getUsers().subscribe(
          data => {
            this.users = data;
          }
        )
      }
    )
  }

  remove(user : User){
    this.service.removeUser(user).subscribe(
      data => {
        this.users = data;
      }
    )
  }

}
