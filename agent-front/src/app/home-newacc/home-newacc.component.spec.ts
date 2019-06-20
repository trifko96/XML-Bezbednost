import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeNewaccComponent } from './home-newacc.component';

describe('HomeNewaccComponent', () => {
  let component: HomeNewaccComponent;
  let fixture: ComponentFixture<HomeNewaccComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeNewaccComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeNewaccComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
