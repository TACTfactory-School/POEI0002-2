import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './menu.component';
import { UserFormModule } from '../user/user-form/user-form.module';
import { RouterModule } from '@angular/router';
import { LogguedGuard } from '../auth/loggued.guard';

@NgModule({
  declarations: [MenuComponent],
  imports: [
    RouterModule,
    UserFormModule,
    CommonModule
  ],
  providers: [LogguedGuard],
  exports: [MenuComponent]
})
export class MenuModule { }
