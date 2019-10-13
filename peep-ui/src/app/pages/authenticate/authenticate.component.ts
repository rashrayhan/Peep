import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-authenticate',
  templateUrl: './authenticate.component.html',
  styleUrls: ['./authenticate.component.scss']
})
export class AuthenticateComponent implements OnInit {
  isShow = true;
  hide = true;

  myForm: FormGroup;
  signUpForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.myForm = this.fb.group({
      email : ['', [
        Validators.required,
        Validators.email
      ]],
      password : '',
    });

    this.signUpForm = this.fb.group({
      name : '',
      email : '',
      handle : '',
      yob : '',
      password : ''
    });

    // this.myForm.valueChanges.subscribe(console.log);
    // this.signUpForm.valueChanges.subscribe(console.log);
  }

  // get email(){
  //   return this.myForm.get('email');
  // }

  public showForm() {
    this.isShow = !this.isShow;
    console.log(this.isShow);
  }
}
