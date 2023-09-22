import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ShareService } from '../share.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor (public http : HttpClient,public router : Router,public sharer : ShareService) {

  }

  activeEmp:any = {};
  hide:boolean = true;
  passValid:boolean=false;
  userValid:boolean=false;
  fulldisplay:boolean=true;
  res:any;
  name:any;

  checkemp() {
    //console.log(this.activeEmp)
    //console.log(this.sharer.field);
    let response = this.http.post("http://localhost:8081/login", this.activeEmp, {responseType: 'text'});

    response.subscribe((data)=>{
      this.res = data;
      if(this.res=="Invalid empId"){
        this.userValid = true;
      }
      else if(this.res=="incorrect Password"){
        this.passValid=true;
      }
      else{
        this.userValid=false;
        this.passValid=false;
        this.sharer.name = this.res.slice(8,);
        this.router.navigate(['showName']);
      }
    })
  }
}
