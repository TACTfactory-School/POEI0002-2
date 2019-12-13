import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import { EventListCardComponent } from './event-list-card.component';
import { RouterModule } from '@angular/router';
import { PipesModule } from 'src/app/pipes/pipes.module';

@NgModule({
  declarations: [EventListCardComponent],
    imports: [
        MatCardModule,
        PipesModule,
        RouterModule,
        CommonModule
    ],
  exports: [EventListCardComponent]
})
export class EventListCardModule { }
