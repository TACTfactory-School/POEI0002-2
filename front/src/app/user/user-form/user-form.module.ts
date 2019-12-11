import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormComponent } from './user-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserFormLoginModule } from './user-form-login/user-form-login.module';

@NgModule({
  declarations: [UserFormComponent],
  imports: [
    ReactiveFormsModule,
    UserFormLoginModule,
    RouterModule,
    CommonModule
  ],
  exports: [UserFormComponent, UserFormLoginModule]
})
export class UserFormModule { }
