import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeLoggedInReservComponent } from './home-logged-in-reserv.component';

describe('HomeLoggedInReservComponent', () => {
  let component: HomeLoggedInReservComponent;
  let fixture: ComponentFixture<HomeLoggedInReservComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeLoggedInReservComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeLoggedInReservComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
