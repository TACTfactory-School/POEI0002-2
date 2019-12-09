import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListComponent } from './event-list.component';
import {MatCardModule} from '@angular/material/card';
import { EventListCardComponent } from './event-list-card/event-list-card.component';

@NgModule({
  declarations: [EventListComponent, EventListCardComponent],
  imports: [
    MatCardModule,
    CommonModule,
    MatCardModule
  ],
  exports: [EventListComponent]
})
export class EventListModule { }
