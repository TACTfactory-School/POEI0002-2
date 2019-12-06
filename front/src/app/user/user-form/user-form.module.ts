import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormComponent } from './user-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [UserFormComponent],
  imports: [
    ReactiveFormsModule,
    RouterModule,
    CommonModule
  ],
  exports: [UserFormComponent]
})
export class UserFormModule { }
