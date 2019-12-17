import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, Validators} from '@angular/forms';
import {EventService} from '../event.service';
import {Event} from '../event';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-event-edit',
  templateUrl: './event-edit.component.html',
  styleUrls: ['./event-edit.component.scss']
})
export class EventEditComponent implements OnInit {

  eventSign = this.fb.group({title: ['',  Validators.required],
    description: ['',  Validators.required],
    id: ['',  Validators.required],
    city: ['', Validators.required],
    nbPlace: ['', Validators.required],
    dueAt: ['', Validators.required],
    enable: ['true', Validators.required],
    photo: [''],
    adresse: [''],
    Cp: ['']
  });

  constructor(private fb: FormBuilder, private service: EventService, private readonly route: ActivatedRoute, ) { }

  onSubmit(): void {
    const event: Event = this.eventSign.value;
    this.service
      .update(event)
      .subscribe();
    console.log('submitted');
  }

  get title(): AbstractControl { return this.eventSign.get('title'); }
  get description(): AbstractControl { return this.eventSign.get('description'); }
  get id(): AbstractControl { return this.eventSign.get('id'); }
  get city(): AbstractControl { return this.eventSign.get('city'); }
  get nbPlace(): AbstractControl { return this.eventSign.get('nbPlace'); }
  get dueAt(): AbstractControl { return this.eventSign.get('dueAt'); }
  get enable(): AbstractControl { return this.eventSign.get('enable'); }
  get photo(): AbstractControl { return this.eventSign.get('photo'); }
  get adresse(): AbstractControl { return this.eventSign.get('adresse'); }
  get Cp(): AbstractControl { return this.eventSign.get('Cp'); }

  ngOnInit() {
    this.route
      .params
      .subscribe(params => {
        if (params.id) {
          this.service
              .getOne(params.id)
              .subscribe(e => this.eventSign.patchValue(e));

        }
      });
  }
}
