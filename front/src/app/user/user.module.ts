import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListModule } from './user-list/user-list.module';
import { UserFormModule } from './user-form/user-form.module';
import { UserFormLoginComponent } from './user-form/user-form-login/user-form-login.component';
import { UserFormLoginModule } from './user-form/user-form-login/user-form-login.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    UserListModule,
    UserFormModule,
    UserFormLoginModule
  ],
  exports: [UserListModule]
})
export class UserModule { }
