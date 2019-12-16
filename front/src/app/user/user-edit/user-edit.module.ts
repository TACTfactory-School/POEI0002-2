import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserEditComponent } from './user-edit.component';

@NgModule({
  declarations: [UserEditComponent],
  imports: [
    CommonModule
  ],
  exports: [UserEditComponent]
})
export class UserEditModule { }
