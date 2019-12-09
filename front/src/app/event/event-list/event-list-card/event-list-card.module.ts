import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import { EventListCardComponent } from './event-list-card.component';

@NgModule({
  declarations: [EventListCardComponent],
  imports: [
    MatCardModule,
    CommonModule
  ],
  exports: [EventListCardComponent]
})
export class EventListCardModule { }
