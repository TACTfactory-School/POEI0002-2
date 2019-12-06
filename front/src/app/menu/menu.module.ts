import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './menu.component';
import { UserFormModule } from '../user/user-form/user-form.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [MenuComponent],
  imports: [
    RouterModule,
    UserFormModule,
    CommonModule
  ],
  exports : [MenuComponent]
})
export class MenuModule { }
