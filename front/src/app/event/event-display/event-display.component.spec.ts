import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { EventDisplayComponent } from './event-display.component';
import { HttpClientTestingModule} from '@angular/common/http/testing';
import {LoaderComponent} from '../../shared/loader/loader.component';
import {MatProgressSpinnerModule} from '@angular/material';

describe('EventDisplayComponent', () => {
  let component: EventDisplayComponent;
  let fixture: ComponentFixture<EventDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule,
                HttpClientTestingModule,
                MatProgressSpinnerModule],
      declarations: [ EventDisplayComponent, LoaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
