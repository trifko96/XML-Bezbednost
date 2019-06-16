import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAccomodationComponent } from './home-accomodation.component';

describe('HomeAccomodationComponent', () => {
  let component: HomeAccomodationComponent;
  let fixture: ComponentFixture<HomeAccomodationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeAccomodationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAccomodationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
