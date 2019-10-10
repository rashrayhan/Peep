import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogpeepComponent } from './dialogpeep.component';

describe('DialogpeepComponent', () => {
  let component: DialogpeepComponent;
  let fixture: ComponentFixture<DialogpeepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogpeepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogpeepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
