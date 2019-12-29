import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListComponent } from './user-list.component';
import { RouterModule } from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import { SharedModule } from 'src/app/shared/shared.module';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [UserListComponent],
  imports: [
    MatButtonModule,
    MatTableModule,
    CommonModule,
    RouterModule,
    SharedModule
  ],
  exports: [UserListComponent]
})
export class UserListModule { }
