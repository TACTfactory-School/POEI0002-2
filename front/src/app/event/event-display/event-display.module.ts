import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventDisplayComponent } from './event-display.component';

@NgModule({
  declarations: [EventDisplayComponent],
  imports: [
    CommonModule
  ],
  exports: [EventDisplayComponent]
})
export class EventDisplayModule { }
