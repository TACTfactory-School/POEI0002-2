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
  private events: Event[];
  private totalElements: number;
  private totalPages: number;
  private pageNumber: number;
  private numberOfElements: number;
  private page = 0;

  constructor(private api: EventService) { }

  ngOnInit() {
    this.getPage();
  }

  getPage() {

    this.api.getAll(this.page).subscribe(
      data => {
        this.events = data[`content`];
        this.totalElements    = data[`totalElements`];
        this.totalPages       = data[`totalPages`];
        this.pageNumber       = data[`pageNumber`];
        this.numberOfElements = data[`numberOfElements`];
      },
      error => {
        console.log(error.error.message);
      }
    );
  }

  setPage(i: number, event: MouseEvent) {
    event.preventDefault();
    this.page = i;
    this.getPage();
  }

  onJoin(eventId: number) {
    this.api.addUser(eventId).subscribe();
  }
}
