import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MeComponent } from './me.component';
import { PipesModule } from '../../pipes/pipes.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [MeComponent],
  imports: [
    CommonModule,
    PipesModule,
    RouterModule
  ],
  exports: [MeComponent]
})
export class MeModule { }
