import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderCoComponent } from './header-co/header-co.component';
import { UserFormModule } from '../user/user-form/user-form.module';
import { RouterModule } from '@angular/router';
import { LogguedGuard } from '../auth/loggued.guard';
import { MatBadgeModule } from '@angular/material/badge';

@NgModule({
  declarations: [HeaderCoComponent],
  imports: [
    RouterModule,
    UserFormModule,
    CommonModule,
    MatBadgeModule
  ],
  providers: [LogguedGuard],
  exports: [HeaderCoComponent]
})
export class HeaderModule { }
