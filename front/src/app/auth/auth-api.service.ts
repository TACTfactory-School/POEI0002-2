import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { TokenStorageService } from './token-storage.service';
import { User } from '../user/user';


const URL = environment.apiUrl;


interface LoginResult {
  access_token: string;
  token_type: string;
  refresh_token: string;
  expires_in: number;
  scope: string;
  jti: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthApiService {

  constructor(
      private readonly http: HttpClient,
      private readonly token: TokenStorageService) { }

  login(username: string, password: string) {
    const body = new HttpParams()
    .set('grant_type', 'password')
    .set('username', username)
    .set('password', password);

    const basic = 'Basic ' + btoa('ANG:POEI0002-2');

    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/x-www-form-urlencoded');
    headers = headers.append('Authorization', basic);

    const options = {headers};

    return this.http.post<LoginResult>(`http://localhost:8777/oauth/token`, body.toString(), options)
    .pipe(tap((res: LoginResult) => this.token.save(res.access_token)));
  }

  logout() {
    console.log('logout');
    this.token.clear();
    return this.http.post<void>(`${URL}/logout`, {})
        .pipe(tap(() => this.token.clear()));
  }

  me() {
    return this.http.get<User>(`${URL}/user/me`);
  }
}
