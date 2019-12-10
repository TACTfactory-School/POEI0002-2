import { NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDisplayComponent } from './user-display.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [UserDisplayComponent],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule
  ],
  exports: [UserDisplayComponent]
})
export class UserDisplayModule { }
