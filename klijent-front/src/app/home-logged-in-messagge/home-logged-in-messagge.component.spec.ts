import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeLoggedInMessaggeComponent } from './home-logged-in-messagge.component';

describe('HomeLoggedInMessaggeComponent', () => {
  let component: HomeLoggedInMessaggeComponent;
  let fixture: ComponentFixture<HomeLoggedInMessaggeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeLoggedInMessaggeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeLoggedInMessaggeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
