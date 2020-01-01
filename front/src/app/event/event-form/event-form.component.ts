import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Event } from '../event';
import { EventService } from '../event.service';
import { CurrentUserService } from '../../auth/current-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.scss']
})

export class EventFormComponent implements OnInit {

  eventSign = this.fb.group({
    title: ['', Validators.required],
    description: ['', Validators.required],
    city: ['', Validators.required],
    nbPlace: ['', Validators.required],
    dueAt: ['', Validators.required],
    enable: ['true', Validators.required]
  });

  constructor(private fb: FormBuilder, private service: EventService, private readonly currentUser: CurrentUserService,
              private readonly router: Router) { }

  onSubmit(): void {
    const event: Event = this.eventSign.value;
    this.service
      .create(event)
      .subscribe(() => this.eventCreateSuccess(event.id));
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

  private eventCreateSuccess(id: number) {
    const route = 'event';
    this.router.navigate([route]);
  }
}
