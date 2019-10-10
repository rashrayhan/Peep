import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DialogpeepComponent } from '../dialogpeep/dialogpeep.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  constructor(
    public dialog: MatDialog
  ) { }

  ngOnInit() {
  }

  openDialog(){
    this.dialog.open(DialogpeepComponent, {
      panelClass: 'app-full-bleed-dialog'
    });
  }

}
