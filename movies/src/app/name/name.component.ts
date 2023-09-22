import { Component } from '@angular/core';
import { ShareService } from '../share.service';

@Component({
  selector: 'app-name',
  templateUrl: './name.component.html',
  styleUrls: ['./name.component.css']
})
export class NameComponent {

  constructor(public sharer : ShareService){}

  namer:String = this.sharer.name;
}
