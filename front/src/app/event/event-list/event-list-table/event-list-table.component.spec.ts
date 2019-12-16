import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EventListTableComponent } from './event-list-table.component';

describe('EventListComponent', () => {
  let component: EventListTableComponent;
  let fixture: ComponentFixture<EventListTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventListTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventListTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
