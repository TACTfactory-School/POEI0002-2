import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {User} from './user';

const URL = `${environment.apiUrl}/user`;

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private readonly http: HttpClient) { }

  getAll() {
    return this.http.get<User[]>(URL);
  }

  getOne(id: number) {
    return this.http.get<User>(`${URL}/${id}`);
  }

  create(user: User) {
    return this.http.post<User>(`${URL}`, user);
  }
}