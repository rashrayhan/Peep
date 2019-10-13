import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.scss']
})
export class AuthenticateComponent implements OnInit {
  isShow = true;
  hide = true;
  constructor() { }

  ngOnInit() {
  }


  public showForm(){
    this.isShow = !this.isShow;
    console.log(this.isShow);
  }
}
