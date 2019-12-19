import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserFormLoginComponent } from './user-form-login.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [UserFormLoginComponent],
  imports: [
    ReactiveFormsModule,
    SharedModule,
    RouterModule,
    CommonModule
  ],
  exports: [UserFormLoginComponent]
})
export class UserFormLoginModule { }
