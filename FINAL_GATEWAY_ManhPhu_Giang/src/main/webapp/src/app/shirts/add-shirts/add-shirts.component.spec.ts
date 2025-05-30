import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddShirtsComponent } from './add-shirts.component';

describe('AddShirtsComponent', () => {
  let component: AddShirtsComponent;
  let fixture: ComponentFixture<AddShirtsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddShirtsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddShirtsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
