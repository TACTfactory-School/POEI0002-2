import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserFormLoginComponent } from './user-form-login.component';

@NgModule({
  declarations: [UserFormLoginComponent],
  imports: [
    ReactiveFormsModule,
    RouterModule,
    CommonModule
  ],
  exports: [UserFormLoginComponent]
})
export class UserFormLoginModule { }
