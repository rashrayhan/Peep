import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DialogpeepComponent } from '../dialogpeep/dialogpeep.component';

@Component({
  selector: 'app-following',
  templateUrl: './following.component.html',
  styleUrls: ['./following.component.scss']
})
export class FollowingComponent implements OnInit {
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
