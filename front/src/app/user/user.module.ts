import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListModule } from './user-list/user-list.module';
import { UserFormModule } from './user-form/user-form.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    UserListModule,
    UserFormModule,
  ],
  exports: [UserListModule]
})
export class UserModule { }
