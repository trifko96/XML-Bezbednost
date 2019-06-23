import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeLoggedInAccComponent } from './home-logged-in-acc.component';

describe('HomeLoggedInAccComponent', () => {
  let component: HomeLoggedInAccComponent;
  let fixture: ComponentFixture<HomeLoggedInAccComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeLoggedInAccComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeLoggedInAccComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
