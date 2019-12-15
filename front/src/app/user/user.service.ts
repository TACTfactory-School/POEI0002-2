import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {User} from './user';
import { Event } from '../event/event';

const URL = `${environment.apiUrl}/user`;

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private readonly http: HttpClient) { }

  getAll(page: number) {
    return this.http.get(`${URL}/public?page=${page}`);
  }

  getOne(id: number) {
    return this.http.get<User>(`${URL}/public/${id}`);
  }

  create(user: User) {
    return this.http.post<User>(`${URL}`, user);
  }

  getAllEvents(id: number) {
    return this.http.get<Event[]>(`${URL}/public/participating/${id}`);
  }
}
