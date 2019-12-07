import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DatetoagePipe } from './datetoage.pipe';

@NgModule({
  declarations: [DatetoagePipe],
  imports: [
    CommonModule
  ],
  exports: [DatetoagePipe]
})
export class PipesModule { }
