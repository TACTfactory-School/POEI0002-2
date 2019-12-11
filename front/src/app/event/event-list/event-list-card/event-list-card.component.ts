import { Component, OnInit } from '@angular/core';
import { Event } from '../../event';
import {EventService} from '../../event.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-event-list-card',
  templateUrl: './event-list-card.component.html',
  styleUrls: ['./event-list-card.component.css']
})
export class EventListCardComponent implements OnInit {
  events: Observable<Event[]>;
  constructor(private api: EventService) { }

  ngOnInit() {
   this.events = this.api.getAll();
  }
}
