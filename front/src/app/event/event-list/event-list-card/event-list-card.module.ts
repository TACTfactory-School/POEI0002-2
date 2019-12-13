import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import { EventListCardComponent } from './event-list-card.component';
import { RouterModule } from '@angular/router';
import {SharedModule} from '../../../shared/shared.module';

@NgModule({
  declarations: [EventListCardComponent],
    imports: [
        MatCardModule,
        RouterModule,
        CommonModule,
        SharedModule
    ],
  exports: [EventListCardComponent]
})
export class EventListCardModule { }
