import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  usernameValue:any;
  hide:boolean = true;
  passwordValue:any;
  passValid:boolean=false;
  userValid:boolean=false;
  whole:boolean=true;

  
}
