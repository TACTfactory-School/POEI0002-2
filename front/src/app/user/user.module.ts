import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListModule } from './user-list/user-list.module';
import { UserFormModule } from './user-form/user-form.module';
import { UserFormLoginModule } from './user-form/user-form-login/user-form-login.module';
import { UserDisplayModule } from './user-display/user-display.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    UserListModule,
    UserFormModule,
    UserDisplayModule,
    UserFormLoginModule
  ],
  exports: [UserListModule, UserFormModule, UserDisplayModule]
})
export class UserModule { }
