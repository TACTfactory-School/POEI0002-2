import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserEditComponent } from './user-edit.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [UserEditComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [UserEditComponent]
})
export class UserEditModule { }
