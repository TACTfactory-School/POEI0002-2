import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {User} from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

users$: Observable<User[]>;

  constructor(private readonly service: UserService) { }

  ngOnInit() {
    this.users$ = this.service.getAll();
  }
}
