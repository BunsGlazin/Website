import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ShareService } from '../share.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(public http : HttpClient,public sharer : ShareService){}

  firstNameValue:any;
  lastNameValue:any;
  res:any;
  activeEntity:any={};

  postemp() {
    this.http.post("http://localhost:8081/newEmp", this.activeEntity, {responseType: 'text'}).subscribe((data)=>{
      this.res=data;
      alert("your empId is "+this.res)
    })
  }
}
