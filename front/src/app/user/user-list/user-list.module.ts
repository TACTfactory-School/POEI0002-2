import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListComponent } from './user-list.component';
import { RouterModule } from '@angular/router';
import {MatTableModule} from '@angular/material/table';
@NgModule({
  declarations: [UserListComponent],
  imports: [
    MatTableModule,
    CommonModule,
    RouterModule
  ],
  exports: [UserListComponent]
})
export class UserListModule { }
