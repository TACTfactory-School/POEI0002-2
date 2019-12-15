import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, Validators} from '@angular/forms';
import {EventService} from '../event.service';
import {CurrentUserService} from '../../auth/current-user.service';
import {Event} from '../event';

@Component({
  selector: 'app-event-edit',
  templateUrl: './event-edit.component.html',
  styleUrls: ['./event-edit.component.scss']
})
export class EventEditComponent implements OnInit {

  eventSign = this.fb.group({title: ['',  Validators.required],
    description: ['',  Validators.required],
    city: ['', Validators.required],
    nbPlace: ['', Validators.required],
    dueAt: ['', Validators.required],
    enable: ['true', Validators.required]
  });

  constructor(private fb: FormBuilder, private service: EventService, private readonly currentUser: CurrentUserService) { }

  onSubmit(): void {
    const event: Event = this.eventSign.value;
    this.service
      .create(event)
      .subscribe();
    console.log('submitted');
  }

  get title(): AbstractControl { return this.eventSign.get('title'); }
  get description(): AbstractControl { return this.eventSign.get('description'); }
  get city(): AbstractControl { return this.eventSign.get('city'); }
  get nbPlace(): AbstractControl { return this.eventSign.get('nbPlace'); }
  get dueAt(): AbstractControl { return this.eventSign.get('dueAt'); }
  get enable(): AbstractControl { return this.eventSign.get('enable'); }

  ngOnInit() {
  }
}
