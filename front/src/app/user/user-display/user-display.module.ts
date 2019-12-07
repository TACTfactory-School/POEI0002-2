import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDisplayComponent } from './user-display.component';
import { DatetoagePipe } from '../../pipes/datetoage.pipe';

@NgModule({
  declarations: [UserDisplayComponent],
  imports: [
    CommonModule,
    DatetoagePipe
  ],
  exports: [UserDisplayComponent]
})
export class UserDisplayModule { }
