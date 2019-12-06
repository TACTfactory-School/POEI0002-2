import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListComponent } from './event-list.component';
import { EventListCardComponent } from './event-list-card/event-list-card.component';

@NgModule({
  declarations: [EventListComponent, EventListCardComponent],
  imports: [
    CommonModule
  ],
  exports: [EventListCardComponent]
})
export class EventListModule { }
