import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEmplComponent } from './add-empl.component';

describe('AddEmplComponent', () => {
  let component: AddEmplComponent;
  let fixture: ComponentFixture<AddEmplComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddEmplComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddEmplComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
