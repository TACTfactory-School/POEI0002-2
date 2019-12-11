import { NgModule } from '@angular/core';
import { EventListCardModule } from './event-list-card/event-list-card.module';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { Router, RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    MatCardModule,
    EventListCardModule
  ],
  exports: [EventListCardModule]
})
export class EventListModule { }
