import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import {Event} from './event';

const URL = `${environment.apiUrl}/event`;

@Injectable({
  providedIn: 'root'
})
export class EventListService {

  constructor(private  http: HttpClient) { }
  getAll() {
    return this.http.get<Event[]>(URL);
  }

}
