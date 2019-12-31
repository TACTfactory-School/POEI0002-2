import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from '../auth/current-user.service';
import { Observable } from 'rxjs';
import { User } from '../user/user';
import { Router } from '@angular/router';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  user: Observable<User>;


  constructor(private readonly currentUser: CurrentUserService, private router: Router) { }

  ngOnInit() {
    this.user = this.currentUser.observable;
  }
}
