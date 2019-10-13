import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { DialogpeepComponent } from '../dialogpeep/dialogpeep.component';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent implements OnInit {
  isShow = true;
  timelineForm: FormGroup;
  comment: FormGroup;
  commentsList: any;

  constructor(
    public dialog: MatDialog,
    private fb: FormBuilder
  ) {
    this.commentsList = [
      {
        'image' : 'assets/avatar.png',
        'user': 'benbow',
        'comment': 'this is hillarious'
    },
    {
      'image' : 'assets/avatar.png',
      'user': 'desh',
      'comment': 'it is working'
  }
    ]
  }

  ngOnInit() {
    this.timelineForm = this.fb.group({
      peep : '',
      peepImg : ''
    });

    this.comment = this.fb.group({
      cmnt : ''
    });
  }

  openDialog(){
    this.dialog.open(DialogpeepComponent, {
      panelClass: 'app-full-bleed-dialog'
    });
  }

  public showSection() {
    this.isShow = !this.isShow;
    console.log(this.isShow);
  }
}
