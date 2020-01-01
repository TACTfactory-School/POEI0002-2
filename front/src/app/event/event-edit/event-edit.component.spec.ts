import {
  async,
  ComponentFixture,
  TestBed
} from '@angular/core/testing';

import {
  EventEditComponent
} from './event-edit.component';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('EventEditComponent', () => {
  let component: EventEditComponent;
  let fixture: ComponentFixture<EventEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [EventEditComponent],
      imports: [ReactiveFormsModule,
        FormsModule,
        RouterTestingModule,
        HttpClientTestingModule],
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
