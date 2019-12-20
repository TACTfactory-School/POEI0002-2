import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EventListTableComponent } from './event-list-table.component';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {MatCardModule} from '@angular/material';
import { MatTableModule } from '@angular/material';
import {PipesModule} from '../../../pipes/pipes.module';

describe('EventListComponent', () => {
  let component: EventListTableComponent;
  let fixture: ComponentFixture<EventListTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule,
                HttpClientTestingModule,
                MatCardModule,
                MatTableModule,
                PipesModule],
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
