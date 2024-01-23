import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleScreeningComponent } from './single-screening.component';

describe('SingleScreeningsComponent', () => {
  let component: SingleScreeningComponent;
  let fixture: ComponentFixture<SingleScreeningComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SingleScreeningComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SingleScreeningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
