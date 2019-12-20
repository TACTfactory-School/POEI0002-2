import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventDisplayComponent } from './event-display.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [EventDisplayComponent],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule
  ],
  exports: [EventDisplayComponent]
})
export class EventDisplayModule { }
