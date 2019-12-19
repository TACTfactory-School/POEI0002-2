import { Component, OnInit } from '@angular/core';
import {Event} from '../event';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { EventService } from '../event.service';
import { User } from '../../user/user';

@Component({
  selector: 'app-event-display',
  templateUrl: './event-display.component.html',
  styleUrls: ['./event-display.component.scss']
})
export class EventDisplayComponent implements OnInit {

  event$: Observable<Event>;
  listeParticipants$: Observable<User[]>;
  listeOrganisators$: Observable<User[]>;

  constructor(private readonly route: ActivatedRoute, private readonly service: EventService) { }

  ngOnInit() {
    this.route
        .params
        .subscribe(params => {
          if (params.id) {
            this.event$ = this.service.getOne(params.id);
            this.listeParticipants$ = this.service.getAllParticipants(params.id);
            this.listeOrganisators$ = this.service.getAllOrganisators(params.id);
          }
        });
  }
  delete(id: number) {
    this.service.delete(id).subscribe();
  }

  onJoin(id: number) {
    this.service.addUser(id).subscribe();
  }
}
