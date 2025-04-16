import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProgrammersComponent } from './add-programmers.component';

describe('AddProgrammersComponent', () => {
  let component: AddProgrammersComponent;
  let fixture: ComponentFixture<AddProgrammersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddProgrammersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddProgrammersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
