import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderCoComponent } from './header-co.component';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('HeaderCoComponent', () => {
  let component: HeaderCoComponent;
  let fixture: ComponentFixture<HeaderCoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HeaderCoComponent],
      imports: [RouterTestingModule,
        HttpClientTestingModule]
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
