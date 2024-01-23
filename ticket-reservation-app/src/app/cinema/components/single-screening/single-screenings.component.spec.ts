import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleScreeningsComponent } from './single-screenings.component';

describe('SingleScreeningsComponent', () => {
  let component: SingleScreeningsComponent;
  let fixture: ComponentFixture<SingleScreeningsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SingleScreeningsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SingleScreeningsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
