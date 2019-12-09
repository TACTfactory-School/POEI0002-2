import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { MenuModule } from './menu/menu.module';
import { LOCALE_ID } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { ErrorModule } from './error/error.module';
import { EventListCardComponent } from './event/event-list/event-list-card/event-list-card.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { UserDisplayComponent } from './user/user-display/user-display.component';
import { AuthModule } from './auth/auth.module';
import { PipesModule } from './pipes/pipes.module';
import { MatCardModule } from '@angular/material/card';
import { EventDisplayComponent } from './event/event-display/event-display.component';
import { UserFormLoginComponent } from './user/user-form/user-form-login/user-form-login.component';
import { UserFormComponent } from './user/user-form/user-form.component';

@NgModule({
  declarations: [
    AppComponent,
    UserDisplayComponent,
    UserFormLoginComponent,
    UserListComponent,
    EventListCardComponent,
    EventDisplayComponent
  ],
  imports: [
    MatCardModule,
    AppRoutingModule,
    HttpClientModule,
    MenuModule,
    BrowserModule,
    BrowserAnimationsModule,
    ErrorModule,
    AuthModule,
    PipesModule,
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'fr-FR'},
    httpInterceptors
  ],
  bootstrap: [AppComponent],

})
export class AppModule { }
