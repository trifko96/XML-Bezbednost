import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAccommodationComponent } from './home-accommodation.component';

describe('HomeAccommodationComponent', () => {
  let component: HomeAccommodationComponent;
  let fixture: ComponentFixture<HomeAccommodationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeAccommodationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAccommodationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
