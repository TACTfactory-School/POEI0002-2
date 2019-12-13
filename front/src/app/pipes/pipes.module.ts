import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DatetoagePipe } from './datetoage.pipe';
import {DateTransformPipe} from './date-transform.pipe';

@NgModule({
  declarations: [DatetoagePipe,
                 DateTransformPipe],
  imports: [
    CommonModule
  ],
  exports: [DatetoagePipe,
            DateTransformPipe]
})
export class PipesModule { }
