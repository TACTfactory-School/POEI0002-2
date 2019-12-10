import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { MenuModule } from './menu/menu.module';
import { LOCALE_ID } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { ErrorModule } from './error/error.module';
import { AuthModule } from './auth/auth.module';
import { PipesModule } from './pipes/pipes.module';
import { httpInterceptors } from './interceptors';
import { MatCardModule } from '@angular/material/card';
import { EventModule } from './event/event.module';
import { UserModule } from './user/user.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    AppRoutingModule,
    HttpClientModule,
    EventModule,
    UserModule,
    MenuModule,
    BrowserModule,
    BrowserAnimationsModule,
    ErrorModule,
    AuthModule,
    PipesModule,
    MatCardModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'fr-FR'},
    httpInterceptors
  ],
  bootstrap: [AppComponent],

})
export class AppModule { }
