import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import {Event} from './event';

const URL = `${environment.apiUrl}/event`;

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private  http: HttpClient) { }

  getAll(page: number) {
    return this.http.get(`${URL}?page=${page}`);
  }

  getOne(id: number) {
    return this.http.get<Event>(`${URL}/${id}`);
  }

  create(event: Event) {
    return this.http.post<Event>(`${URL}`, event);
  }

  delete(id: number) {
    return this.http.delete(`${URL}/${id}`);
  }
}
