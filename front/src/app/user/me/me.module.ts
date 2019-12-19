import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MeComponent } from './me.component';
import { PipesModule } from '../../pipes/pipes.module';
import { RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [MeComponent],
  imports: [
    CommonModule,
    PipesModule,
    RouterModule,
    SharedModule
  ],
  exports: [MeComponent]
})
export class MeModule { }
