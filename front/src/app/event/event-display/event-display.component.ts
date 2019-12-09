import { Component, OnInit } from '@angular/core';
import {Event} from '../event';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { EventService } from '../event.service';

@Component({
  selector: 'app-event-display',
  templateUrl: './event-display.component.html',
  styleUrls: ['./event-display.component.scss']
})
export class EventDisplayComponent implements OnInit {

  event$: Observable<Event>;

  constructor(private readonly route: ActivatedRoute, private readonly service: EventService) { }

  ngOnInit() {
    this.route
        .params
        .subscribe(params => {
          if (params.id) {
            this.event$ = this.service.getOne(params.id);
          }
        });
  }
}
