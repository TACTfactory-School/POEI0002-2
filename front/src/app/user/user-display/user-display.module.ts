import { NgModule} from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDisplayComponent } from './user-display.component';
import { RouterModule } from '@angular/router';
import { PipesModule } from 'src/app/pipes/pipes.module';

@NgModule({
  declarations: [UserDisplayComponent],
  imports: [
    CommonModule,
    PipesModule,
    RouterModule
  ],
  exports: [UserDisplayComponent]
})
export class UserDisplayModule { }
