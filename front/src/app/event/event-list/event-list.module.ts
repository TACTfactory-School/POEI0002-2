import { NgModule } from '@angular/core';
import { EventListCardModule } from './event-list-card/event-list-card.module';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { Router, RouterModule } from '@angular/router';
import { EventListTableModule } from './event-list-table/event-list-table.module';

@NgModule({
  imports: [
    CommonModule,
    MatCardModule,
    EventListCardModule,
    EventListTableModule
  ],
  exports: [EventListCardModule]
})
export class EventListModule { }
