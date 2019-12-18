import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-loader',
  templateUrl: 'loader.component.html',
  styleUrls: ['loader.component.scss']
})
export class LoaderComponent {
  @Input()
  readonly text = 'Chargement...';

  @Output()
  private animationFinished = new EventEmitter<void>();

  @Input()
  set animationDuration(millis: number) {
    if (millis) {
      setTimeout(() => this.animationFinished.emit(), millis);
    }
  }
}
