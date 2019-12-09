import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EventListCardComponent } from './event-list-card.component';

describe('EventListComponent', () => {
  let component: EventListCardComponent;
  let fixture: ComponentFixture<EventListCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventListCardComponent ]
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
