import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListModule } from './event-list/event-list.module';
import { EventFormModule } from './event-form/event-form.module';
import { MatCardModule } from '@angular/material/card';
import { EventDisplayModule } from './event-display/event-display.module';
import { SharedModule } from '../shared/shared.module';
import { EventEditModule } from './event-edit/event-edit.module';

@NgModule({
  imports: [
    CommonModule,
    EventListModule,
    EventFormModule,
    EventDisplayModule,
    EventEditModule,
    MatCardModule,
    SharedModule
  ],
  exports: [EventListModule, EventDisplayModule, EventFormModule, EventEditModule]
})
export class EventModule { }
