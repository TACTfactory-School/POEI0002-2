import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListModule } from './event-list/event-list.module';
import { EventFormModule } from './event-form/event-form.module';

@NgModule({
  imports: [
    CommonModule,
    EventListModule,
    EventFormModule
  ],
  exports: [EventListModule]
})
export class EventModule { }
