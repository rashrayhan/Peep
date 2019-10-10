import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DialogpeepComponent } from '../dialogpeep/dialogpeep.component';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent implements OnInit {
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
