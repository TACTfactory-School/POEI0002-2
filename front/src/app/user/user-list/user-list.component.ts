import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';
import { UserService } from '../user.service';
import { Event } from '../../event/event';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  private users: User[];
  private totalElements: number;
  private totalPages: number;
  private pageNumber: number;
  private numberOfElements: number;
  private page = 0;

  displayedColumns = ['username', 'city', 'profession', 'picture', 'detail'];

  constructor(private readonly service: UserService) { }

  ngOnInit() {
    this.getPage();
  }

  getPage() {

    this.service.getAll(this.page).subscribe(
      data => {
        this.users = data[`content`];
        this.totalElements = data[`totalElements`];
        this.totalPages = data[`totalPages`];
        this.pageNumber = data[`pageNumber`];
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
}
