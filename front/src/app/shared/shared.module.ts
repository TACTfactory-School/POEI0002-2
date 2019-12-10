import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PipesModule } from '../pipes/pipes.module';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    PipesModule
  ],
exports: [PipesModule]
})
export class SharedModule { }
