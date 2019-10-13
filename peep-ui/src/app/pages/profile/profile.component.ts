import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DialogpeepComponent } from '../dialogpeep/dialogpeep.component';
import { ProfiledialogComponent } from '../profiledialog/profiledialog.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

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

  openProfileDialog(){
    this.dialog.open(ProfiledialogComponent, {
      panelClass: 'app-full-bleed-dialog'
    });
  }
}
