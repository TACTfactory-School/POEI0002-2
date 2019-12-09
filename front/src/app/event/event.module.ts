import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListModule } from './event-list/event-list.module';
import { EventFormModule } from './event-form/event-form.module';
import { MatCardModule } from '@angular/material/card';

@NgModule({
  imports: [
    CommonModule,
    EventListModule,
    EventFormModule,
    MatCardModule
  ],
  exports: [EventListModule]
})
export class EventModule { }
