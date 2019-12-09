import { Component, OnInit } from '@angular/core';
import { Event } from '../event';
import {EventListService} from '../event-list.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  events: Observable<Event[]> = null;
  constructor(private api: EventListService) { }

  ngOnInit() {
   this.events = this.api.getAll();
  }

}
