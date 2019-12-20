import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import { Event } from '../../event/event';
import { Observable, combineLatest, forkJoin } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { map, tap } from 'rxjs/operators';

@Component({
  selector: 'app-me',
  templateUrl: './me.component.html',
  styleUrls: ['./me.component.scss']
})
export class MeComponent implements OnInit {

  // user$: Observable<User>;
  // listEvents$: Observable<Event[]>;

  user: User;
  listEvents: Event[];
  loaded: boolean;

  constructor(private readonly route: ActivatedRoute, private readonly service: UserService, private readonly meService: AuthApiService) { }

  ngOnInit() {
    this.loaded = false;

    this.route.url
    .subscribe(params => {
      forkJoin(this.meService.me(), this.service.getAllMeEvents())
      .subscribe((results: any) => {
        this.user = results[0].me;
        this.listEvents = results[1].events;
        this.loaded = true;
      });
      // ).pipe(
      //   map((results: any) => {
      //     this.user = results[0].me;
      //     this.listEvents = results[1].events;
      //   }),
      //   tap(() => this.loaded = true)
      // );
    });
  }
}
