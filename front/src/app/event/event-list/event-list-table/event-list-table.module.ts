import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import { EventListTableComponent } from './event-list-table.component';
import { RouterModule } from '@angular/router';
import { PipesModule } from 'src/app/pipes/pipes.module';
import {MatTableModule} from '@angular/material/table';

@NgModule({
  declarations: [EventListTableComponent],
    imports: [
      MatTableModule,
      MatCardModule,
      PipesModule,
      RouterModule,
      CommonModule
    ],
  exports: [EventListTableComponent]
})
export class EventListTableModule { }
