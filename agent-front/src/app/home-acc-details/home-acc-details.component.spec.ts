import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAccDetailsComponent } from './home-acc-details.component';

describe('HomeAccDetailsComponent', () => {
  let component: HomeAccDetailsComponent;
  let fixture: ComponentFixture<HomeAccDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeAccDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAccDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
