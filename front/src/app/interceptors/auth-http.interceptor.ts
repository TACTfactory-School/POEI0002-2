import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from '../auth/token-storage.service';
import { tap } from 'rxjs/operators';

@Injectable()
export class AuthHttpInterceptor implements HttpInterceptor {
  private token: string;

  constructor(readonly tokenStorage: TokenStorageService) {
    this.tokenStorage.observable.
      pipe(tap(token => console.log('Interceptor got new token', { token }))).
      subscribe(token => this.token = token ? 'Bearer ' + token : null);
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    console.log('INTERCEPT', { req, token: this.token });
    return next.handle(this.token ? this.buildRequest(req) : req);
  }

  private buildRequest(req: HttpRequest<any>): HttpRequest<any> {
    return req.clone({
      headers: req.headers.set('Authorization', this.token)
    });
  }
}
