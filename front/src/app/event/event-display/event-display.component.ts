import { Component, OnInit } from '@angular/core';
import {Event} from '../event';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { EventService } from '../event.service';
import { User } from '../../user/user';
import {CurrentUserService} from '../../auth/current-user.service';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-event-display',
  templateUrl: './event-display.component.html',
  styleUrls: ['./event-display.component.scss']
})
export class EventDisplayComponent implements OnInit {

  event$: Observable<Event>;
  listeParticipants$: Observable<User[]>;
  listeOrganisators$: Observable<User[]>;
  user: Observable<User>;
  freeplace: number;

  constructor(private readonly route: ActivatedRoute, private readonly service: EventService,
              private readonly currentUser: CurrentUserService) { }
  ngOnInit() {
    this.route
        .params
        .subscribe(params => {
          if (params.id) {
            this.event$ = this.service.getOne(params.id);
            this.listeParticipants$ = this.service.getAllParticipants(params.id);
            this.listeOrganisators$ = this.service.getAllOrganisators(params.id);
            this.user = this.currentUser.observable;
          }
        });
  }
  delete(id: number) {
    this.service.delete(id).subscribe();
  }

  onJoin(id: number) {
    this.service.addUser(id).subscribe();
    this.ngOnInit();
  }
  onDisjoin(id: number) {
    this.service.disjoin(id).subscribe();
    this.ngOnInit();
  }
  onOrganisator(id: number) {
    this.service.addOrganisator(id).subscribe();
    this.ngOnInit();
  }
}
