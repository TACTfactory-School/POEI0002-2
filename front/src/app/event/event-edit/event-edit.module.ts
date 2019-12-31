import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventEditComponent } from './event-edit.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [EventEditComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class EventEditModule { }
