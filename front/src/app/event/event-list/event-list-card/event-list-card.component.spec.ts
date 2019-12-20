import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EventListCardComponent } from './event-list-card.component';
import { RouterTestingModule } from '@angular/router/testing';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {MatCardModule, MatProgressSpinnerModule} from '@angular/material';
import {LoaderComponent} from '../../../shared/loader/loader.component';

describe('EventListComponent', () => {
  let component: EventListCardComponent;
  let fixture: ComponentFixture<EventListCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientTestingModule,
        MatCardModule,
        MatProgressSpinnerModule],
      declarations: [
        EventListCardComponent,
        LoaderComponent]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventListCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
