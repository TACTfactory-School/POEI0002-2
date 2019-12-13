import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../../auth/current-user.service';
import { Observable } from 'rxjs';
import { User } from '../../user/user';

@Component({
  selector: 'app-header-co',
  templateUrl: './header-co.component.html',
  styleUrls: ['./header-co.component.scss']
})
export class HeaderCoComponent implements OnInit {

  user: Observable<User>;

  constructor(private readonly currentUser: CurrentUserService) { }

  ngOnInit() {
    this.user = this.currentUser.observable;
  }
}
