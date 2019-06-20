import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeMessaggesComponent } from './home-messagges.component';

describe('HomeMessaggesComponent', () => {
  let component: HomeMessaggesComponent;
  let fixture: ComponentFixture<HomeMessaggesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeMessaggesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeMessaggesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
