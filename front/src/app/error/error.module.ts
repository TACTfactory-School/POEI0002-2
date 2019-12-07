import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagenotfoundModule } from './pagenotfound/pagenotfound.module';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

@NgModule({
  declarations: [PagenotfoundComponent],
  imports: [
    CommonModule,
  ],
  exports: [PagenotfoundComponent]
})
export class ErrorModule { }
