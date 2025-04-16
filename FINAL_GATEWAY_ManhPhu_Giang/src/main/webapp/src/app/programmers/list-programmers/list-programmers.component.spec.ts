import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProgrammersComponent } from './list-programmers.component';

describe('ListProgrammersComponent', () => {
  let component: ListProgrammersComponent;
  let fixture: ComponentFixture<ListProgrammersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListProgrammersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListProgrammersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
