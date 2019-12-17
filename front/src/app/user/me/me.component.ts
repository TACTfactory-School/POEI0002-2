import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import { Event } from '../../event/event';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
import { AuthApiService } from 'src/app/auth/auth-api.service';

@Component({
  selector: 'app-me',
  templateUrl: './me.component.html',
  styleUrls: ['./me.component.scss']
})
export class MeComponent implements OnInit {

  user$: Observable<User>;
  listEvents$: Observable<Event[]>;

  constructor(private readonly route: ActivatedRoute, private readonly service: UserService, private readonly meservice: AuthApiService) { }

  ngOnInit() {
    this.route.url
        .subscribe(params => {
          this.user$ = this.meservice.me();
          this.listEvents$ = this.service.getAllMeEvents();
        });
  }
}
