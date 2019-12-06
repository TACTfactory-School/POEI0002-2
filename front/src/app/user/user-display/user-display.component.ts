import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-display',
  templateUrl: './user-display.component.html',
  styleUrls: ['./user-display.component.scss']
})
export class UserDisplayComponent implements OnInit {

  user$: Observable<User>;

  constructor(private readonly route: ActivatedRoute, private readonly service: UserService) { }

  ngOnInit() {
    this.route
        .params
        .subscribe(params => {
          if (params.id) {
            this.user$ = this.service.getOne(params.id);
          }
        });
  }
}
