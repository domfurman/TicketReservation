import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllScreeningsComponent } from './all-screenings.component';

describe('AllScreeningsComponent', () => {
  let component: AllScreeningsComponent;
  let fixture: ComponentFixture<AllScreeningsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllScreeningsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllScreeningsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
