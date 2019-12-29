import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormComponent } from './user-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserFormLoginModule } from './user-form-login/user-form-login.module';
import {MatSelectModule} from '@angular/material/select';
import { SharedModule } from 'src/app/shared/shared.module';
import {MatTooltipModule} from '@angular/material/tooltip';

@NgModule({
  declarations: [UserFormComponent],
  imports: [
    MatTooltipModule,
    ReactiveFormsModule,
    MatSelectModule,
    UserFormLoginModule,
    RouterModule,
    SharedModule,
    CommonModule
  ],
  exports: [UserFormComponent, UserFormLoginModule]
})
export class UserFormModule { }
