import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventDisplayComponent } from './event-display.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [EventDisplayComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [EventDisplayComponent]
})
export class EventDisplayModule { }
