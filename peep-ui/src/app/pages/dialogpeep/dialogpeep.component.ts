import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-dialogpeep',
  templateUrl: './dialogpeep.component.html',
  styleUrls: ['./dialogpeep.component.scss']
})
export class DialogpeepComponent implements OnInit {
  dialogPeepForm: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.dialogPeepForm = this.fb.group({
      peep : '',
      peepImg : ''
    });
  }

}
