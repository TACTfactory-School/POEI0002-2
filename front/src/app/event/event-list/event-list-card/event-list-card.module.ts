import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { EventListCardComponent } from './event-list-card.component';
import { RouterModule } from '@angular/router';
import { PipesModule } from 'src/app/pipes/pipes.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatPaginatorModule } from '@angular/material/paginator';
@NgModule({
  declarations: [EventListCardComponent],
  imports: [
    MatPaginatorModule,
    MatButtonToggleModule,
    MatCardModule,
    PipesModule,
    RouterModule,
    SharedModule,
    CommonModule
  ],
  exports: [EventListCardComponent]
})
export class EventListCardModule { }
