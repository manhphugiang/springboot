import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListShirtsComponent } from './list-shirts.component';

describe('ListShirtsComponent', () => {
  let component: ListShirtsComponent;
  let fixture: ComponentFixture<ListShirtsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListShirtsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListShirtsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
