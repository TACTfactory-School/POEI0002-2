import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import {Event} from './event';
import { User } from '../user/user';

const URL = `${environment.apiUrl}/event`;

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private  http: HttpClient) { }

  getAll(page: number) {
    return this.http.get(`${URL}/public?page=${page}`);
  }

  getOne(id: number) {
    return this.http.get<Event>(`${URL}/public/${id}`);
  }

  create(event: Event) {
    return this.http.post<Event>(`${URL}`, event);
  }

  update(event: Event) {
    return this.http.put<Event>(`${URL}/${event.id}`, event);
  }

  delete(id: number) {
    return this.http.delete(`${URL}/${id}`);
  }
  addUser(eventId: number) {
    return this.http.get(`${URL}/join/${eventId}`);
  }

  getAllParticipants(id: number) {
    return this.http.get<User[]>(`${URL}/public/participants/${id}`);
  }
}
