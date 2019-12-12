import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Event } from '../event';
import { EventService } from '../event.service';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.scss']
})

export class EventFormComponent implements OnInit {

  eventSign = this.fb.group({title: ['',  Validators.required],
                            description: ['',  Validators.required],
                            author: ['', Validators.required],
                            city: ['', Validators.required],
                            nbPlace: ['', Validators.required],
                            dueAt: ['', Validators.required],
                            enable: ['true', Validators.required]
                          });

  constructor(private fb: FormBuilder, private service: EventService) { }

  onSubmit(): void {
    const event: Event = this.eventSign.value;
    this.service
        .create(event)
        .subscribe();
    console.log('submitted');
  }

  get title(): AbstractControl { return this.eventSign.get('title'); }
  get description(): AbstractControl { return this.eventSign.get('description'); }
  get author(): AbstractControl { return this.eventSign.get('author'); }
  get city(): AbstractControl { return this.eventSign.get('city'); }
  get nblace(): AbstractControl { return this.eventSign.get('nbPlace'); }
  get dueAt(): AbstractControl { return this.eventSign.get('dueAt'); }
  get enable(): AbstractControl { return this.eventSign.get('enable'); }

  ngOnInit() {
  }
}
