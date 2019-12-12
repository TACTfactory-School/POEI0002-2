import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderCoComponent } from './header-co.component';

describe('HeaderCoComponent', () => {
  let component: HeaderCoComponent;
  let fixture: ComponentFixture<HeaderCoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderCoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderCoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
