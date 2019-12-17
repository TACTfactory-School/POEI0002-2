import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListModule } from './user-list/user-list.module';
import { UserFormModule } from './user-form/user-form.module';
import { UserDisplayModule } from './user-display/user-display.module';
import { MeModule } from './me/me.module';
import { UserEditModule } from './user-edit/user-edit.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MeModule,
    UserListModule,
    UserFormModule,
    UserDisplayModule,
    UserEditModule
  ],
  exports: [UserListModule, UserFormModule, UserDisplayModule, MeModule, UserEditModule]
})
export class UserModule { }
